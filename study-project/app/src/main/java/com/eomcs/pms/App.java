package main.java.com.eomcs.pms;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import main.java.com.eomcs.menu.Menu;
import main.java.com.eomcs.menu.MenuGroup;
import main.java.com.eomcs.pms.domain.Board;
import main.java.com.eomcs.pms.domain.Member;
import main.java.com.eomcs.pms.domain.Project;
import main.java.com.eomcs.pms.domain.Task;
import main.java.com.eomcs.pms.handler.AuthHandler;
import main.java.com.eomcs.pms.handler.BoardHandler;
import main.java.com.eomcs.pms.handler.MemberHandler;
import main.java.com.eomcs.pms.handler.ProjectHandler;
import main.java.com.eomcs.pms.handler.TaskHandler;
import main.java.com.eomcs.util.Prompt;

public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();
  List<Task> taskList = new LinkedList<>();

  BoardHandler boardHandler = new BoardHandler(boardList);
  MemberHandler memberHandler = new MemberHandler(memberList);
  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
  TaskHandler taskHandler = new TaskHandler(taskList, memberHandler);
  AuthHandler authHandler = new AuthHandler(memberList);

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  void service() {
    createMenu().execute();
    Prompt.close();
    
   
  
  
}
  //이렇게 게시글 데이터를 저장할 때 , 나름의 형식에 따라 데이터를 출력한다
  // -처음 4바이트는 저장할 게시글의 개수이고
  // - 그다음 4바이트는 게시글의 번호
  // - 그 다음 4바이트는 제목의 바이트 개수
  //  이런 식으로 

  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new Menu("로그인", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        authHandler.login(); 
      }
    });

    mainMenuGroup.add(new Menu("내정보", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        authHandler.displayLoginUser(); 
      }
    });

    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        authHandler.logout(); 
      }
    });

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardHandler.add(); 
      }});
    boardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectHandler.add(); 
      }});
    projectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list(); 
      }});
    projectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail(); 
      }});
    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectHandler.update(); 
      }});
    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectHandler.delete(); 
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskHandler.add(); 
      }});
    taskMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list(); 
      }});
    taskMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail(); 
      }});
    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskHandler.delete(); 
      }});


    return mainMenuGroup;
  }
  
  private void saveBoards() {
    //게시글 데이터를 파일로 내보내기 (저장하기 , 쓰기 )
    //출력 스트림 
try (FileOutputStream out = new FileOutputStream("board.data");
    
    
    //파일에 바이트를 출력하기 전에 바이트 단위로 쪼개는 일을 하는 데코레이터
     DataOutputStream out2 = new DataOutputStream(out);
    ) {
  
  //  출력할 게시글 개수 먼저 저장
  
    out2.writeInt(boardList.size());
    
    for(Board board : boardList) {
      
      //1) 게시글 번호 4바이트 출력

      
      out2.writeInt(board.getNo());
      
      //2) 게시글 제목 
     
      out2.writeUTF(board.getTitle());
      
      //3) 게시글 내용 출력
      out2.writeUTF(board.getContent());
      
      
      //4) 게시글 등록일 출력
      out2.writeUTF(board.getRegisteredDate().toString());
      
      
      //5) 게시글 조회수 출력
      out2.writeInt(board.getViewCount());
      
      
      //6) 게시글 작성자 번호 출력 
      out2.writeInt(board.getWriter().getNo());
      
      
      //7) 게시글 작성자 이름 출력
      out2.writeUTF(board.getWriter().getName());
    }
}catch (Exception e) {
  System.out.println("게시글을 파일에 저장 중 오류 발생!");
}
 
  }
  private void loadBorads() {
    try (
        //파일에서 바이트를 읽어오는 일을 하는 객체
        FileInputStream in = new FileInputStream("board.data");
        
        //읽은 바이트를 가공하여 primitiveㅌ입의 값이나 String 객체로 가공하는 일을 하는 객체
        
        DataInputStream in2 = new DataInputStream(in);
        
        ) {
      int size = (in.read()<<24) | (in.read()<<16) | (in.read() << 8) | in.read();
      for (int i = 0; i < size; i++) {
        Board board = new Board();
        
        
        //1 게시글 번호 읽기.
        board.setNo((in.read() << 24 ) | (in.read() << 16) | (in.read() << 8) | in.read());
        
        //2 게시글 제목 읽기
        int strlen = (in.read() << 8) | in.read();  //제목 문자열의 바이트 수
        byte[] buf = new byte[strlen]; // 문자열의 바이트를 담을 배열 준비
        in.read(buf); // 문자열의 바이트를 배열에 담음 
        String str = new String(buf, "UTF-8"); //바이트 배열을 가지고 String 객체 만듬
        board.setTitle(str); //Board 객체에 제목을 담음.
      
        //3 게시글 내용 읽기
        buf = new byte[(in.read() << 8 ) | in.read()];
        in.read(buf);
        board.setContent(new String(buf, "UTF-8"));
        
        //4 게시글 등록일 읽기
        
        buf = new byte[(in.read() << 8) | in.read() ];
        in.read(buf);
        Date regDate = Date.valueOf(new String (buf , "UTF-8"));
        board.setRegisteredDate(regDate);
        
        //5 게시글 조회수 읽기
        board.setViewCount((in.read()<<24) | (in.read()<<16) | (in.read() << 8) | in.read());
      
        //6 작성자 정보 읽기
        Member writer = new Member();
        
        //- 작성자 번호 읽기
        writer.setNo((in.read()<<24) | (in.read()<<16) | (in.read() << 8) | in.read());
        
        
        //작성자 이름 읽기
        buf = new byte[(in.read() << 8 )  | in.read()];
        in.read(buf);
        writer.setName(new String(buf , "UTF=8"));
        
        //게시글에 작성한 
        board.setWriter(writer);
        
        //목록에 게시글 저장.
        boardList.add(board);
        
      } 
      }catch (Exception e) {
        System.out.println("게시글을 파일에 저장 중 오류 발생!");
      }
    }
  }
  










