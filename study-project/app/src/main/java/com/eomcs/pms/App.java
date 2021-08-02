package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();
    
    
   
   
    //ProjectHandler의 메서드가 사용할 의존 객체를 
    //미리 주입함
   
    // - 생성자를 도입하라!
    ProjectHandler projectHandler = new ProjectHandler(memberHandler);

    // 생성자를 이용하면 다음과 같이 인스턴스를 생성할 때 의존 객체 주입을 강제할 수 있다.
    TaskHandler taskHandler = new TaskHandler(memberHandler);

    while (true) {
      
      String menuId = null;
      System.out.println("메인----------------------");
      System.out.println("1.게시판");
      System.out.println("2.회원");
      System.out.println("3.프로젝트");
      System.out.println("4.작업");
      System.out.println("0.종료!");
      int MenuNo = Prompt.inputInt("메인> ");
      if (MenuNo==0) {
        System.out.println("안녕!");
        break;
      }
       else if(MenuNo==1) {
         while(true) {
         System.out.println("1. 등록");
         System.out.println("2. 목록");
         System.out.println("3. 상세 보기");
         System.out.println("4. 변경");
         System.out.println("5. 삭제");
         System.out.println("0. 이전 메뉴");
         MenuNo = Prompt.inputInt("게시판> ");
         if (MenuNo==0) {
           break;
         }
      }
       }
       
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      } else if (input.equals("/member/detail")) {
        memberHandler.detail();

      } else if (input.equals("/member/update")) {
        memberHandler.update();

      } else if (input.equals("/member/delete")) {
        memberHandler.delete();

      }  else if (input.equals("/project/add")) {
        //add() method가 사용할 의존 객체를 미리 주입했기 때문에
        //이제 파라미터로 주입할 필요가 없다.
        //projectHandler.add(memberHandler);
          projectHandler.add();
      }  else if (input.equals("/project/list")) {
        projectHandler.list();

      }  else if (input.equals("/project/detail")) {
        projectHandler.detail();

      }  else if (input.equals("/project/update")) {
        projectHandler.update();
        //update() 메서드가 사용할 의존 객체를 미리 주입했기 떄문에
        //이제 파라미터로 주입할 필요가 없다.
        //projectHandler.update(memberHandler);
        
      }  else if (input.equals("/project/delete")) {
        projectHandler.delete();

      }  else if (input.equals("/task/add")) {
          taskHandler.add();
        //taskHandler.add(memberHandler);

      }  else if (input.equals("/task/list")) {
        taskHandler.list();

      }  else if (input.equals("/task/detail")) {
        taskHandler.detail();

      }  else if (input.equals("/task/update")) {
          taskHandler.update();
        //taskHandler.update(memberHandler);

      }  else if (input.equals("/task/delete")) {
        taskHandler.delete();

      }  else if (input.equals("/board/add")) {
        boardHandler.add();

      }  else if (input.equals("/board/list")) {
        boardHandler.list();

      }  else if (input.equals("/board/detail")) {
        boardHandler.detail();

      }  else if (input.equals("/board/update")) {
        boardHandler.update();

      }  else if (input.equals("/board/delete")) {
        boardHandler.delete();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
  }
}












