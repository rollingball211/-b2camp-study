package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.pms.menu.Menu;
import com.eomcs.pms.menu.MenuGroup;
import com.eomcs.util.Prompt;

public class App {
   BoardHandler boardHandler = new BoardHandler();
   MemberHandler memberHandler = new MemberHandler();
   ProjectHandler projectHandler = new ProjectHandler(memberHandler);
   TaskHandler taskHandler = new TaskHandler(memberHandler);

  
  //main()메서드와 doxxxMenu( 메서드가 공유하는 변수 => static 멤버로 만듬
  public static void main(String[] args) {

   
    
    //1) 메인 메뉴를 출력하고 번호를 입력받음.
    // 0번을 입력하면 프로그램을 종료함.
    
    //2) 게시판 메뉴를 출력하고 번호 입력받음.
    //- 사용자가 입력한 메뉴 번호에 따라 실행할 명령어 SWITCH문에 넣음.
    
   //3&4) 나머지 프로젝트의 작업 메뉴 출력 후 번호 입력받음.
    //메뉴 번호를 입력했을 때 해당 가능을 바로 실행하게 함.
    
    //5) 메인메뉴들을 메소드로 추출.
    
  
    App a = new App();
    a.service();
      

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
   }
  void service() {
    createMenu().execute();
    Prompt.close();
  }
  
   Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");
    
    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);
    //local class
    
    boardMenu.add(new Menu("등록") {
    public void execute() {
      boardHandler.add();
    }
    });
   
    boardMenu.add(new Menu("목록") {
      public void execute() {
        boardHandler.list();
      }
      });
     
    boardMenu.add(new Menu("상세 조회") {
      public void execute() {
        boardHandler.detail();
      }
      });
    
    boardMenu.add(new Menu("수정") {
      public void execute() {
        boardHandler.update();
      }
      });
    
    boardMenu.add(new Menu("삭제") {
      public void execute() {
        boardHandler.delete();
      }
      });
    
    MenuGroup memberMenu = new MenuGroup("회원 목록");
    mainMenuGroup.add(memberMenu);
    
      memberMenu.add(new Menu("멤버 추가") {
      public void execute() {
        memberHandler.add();
      }
      });
      
      
      memberMenu.add(new Menu("멤버 목록") {
        public void execute() {
          memberHandler.list();
        }
        });
      
      
      
      memberMenu.add(new Menu("멤버 상세조회") {
        public void execute() {
          memberHandler.detail();
        }
        });
      
      
      
      memberMenu.add(new Menu("멤버 수정") {
        public void execute() {
          memberHandler.update();
        }
        });
      
      
      memberMenu.add(new Menu("멤버 삭제") {
        public void execute() {
          memberHandler.delete();
        }
        });
      
    MenuGroup projectMenu = new MenuGroup("프로젝트 목록");
    mainMenuGroup.add(projectMenu);
    
    projectMenu.add(new Menu("프로젝트 추가") {
      public void execute() {
        projectHandler.add();
      }
      });
    
    projectMenu.add(new Menu("프로젝트 목록") {
      public void execute() {
        projectHandler.list();
      }
      });
    
    
    projectMenu.add(new Menu("프로젝트 조회") {
      public void execute() {
        projectHandler.detail();
      }
      });
    
    projectMenu.add(new Menu("프로젝트 수정") {
      public void execute() {
        projectHandler.update();
      }
      });
    
    projectMenu.add(new Menu("프로젝트 삭제") {
      public void execute() {
        projectHandler.delete();
      }
      });
    
    MenuGroup taskMenu = new MenuGroup("작업 목록");
    mainMenuGroup.add(taskMenu);
    
    
    taskMenu.add(new Menu("작업 추가") {
      public void execute() {
        taskHandler.add();
      }
      });
    
    taskMenu.add(new Menu("작업 목록") {
      public void execute() {
        taskHandler.list();
      }
      });
    
    taskMenu.add(new Menu("작업 상세조회") {
      public void execute() {
        taskHandler.detail();
      }
      });
    
    
    taskMenu.add(new Menu("작업 수정") {
      public void execute() {
        taskHandler.update();
      }
      });
    
    
    taskMenu.add(new Menu("작업 삭제") {
      public void execute() {
        taskHandler.delete();
      }
      });

    return mainMenuGroup;
    
  }
}

    











