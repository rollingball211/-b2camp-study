package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App4 {
  static  BoardHandler boardHandler = new BoardHandler();
  static  MemberHandler memberHandler = new MemberHandler();
  static  ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static  TaskHandler taskHandler = new TaskHandler(memberHandler);

  
  //main()메서드와 doxxxMenu( 메서드가 공유하는 변수 => static 멤버로 만듬
  public static void main(String[] args) {

   
    
    //1) 메인 메뉴를 출력하고 번호를 입력받음.
    // 0번을 입력하면 프로그램을 종료함.
    
    //2) 게시판 메뉴를 출력하고 번호 입력받음.
    //- 사용자가 입력한 메뉴 번호에 따라 실행할 명령어 SWITCH문에 넣음.
    
   //3&4) 나머지 프로젝트의 작업 메뉴 출력 후 번호 입력받음.
    //메뉴 번호를 입력했을 때 해당 가능을 바로 실행하게 함.
    
    //5) 메인메뉴들을 메소드로 추출.
    while (true) {
      
      
      int MenuNo = doMainMenu();
      
      //사용자가 명령어를 직접 입력하는 대신에
      //제시된 메뉴의 번호를 선택하면 
      //실행할 명령어를 설정한다.
      if (MenuNo==0) {
       break;
      }
       else if  (MenuNo==1) {
         doBoardMenu();
       }
       else if  (MenuNo==2) {
         doMemberMenu();
        }
       else if  (MenuNo==3) {
         doProjectMenu();
        }
       else if  (MenuNo==4) {
        doTaskMenu();
        }
     
     
      

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
   }
  }
  
  
  static void doBoardMenu() {
    while(true) {
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세 보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전 메뉴");
      int MenuNo = Prompt.inputInt("게시판> ");
     switch (MenuNo) {
       case 1: boardHandler.add(); break;
       case 2: boardHandler.list(); break ;
       case 3: boardHandler.detail(); break ;
       case 4: boardHandler.update(); break ;
       case 5: boardHandler.delete();break;
       case 0: return;
       default:
         System.out.println("무효한 메뉴 번호입니다.");
         
      }
     
     
     
     
     System.out.println();
   }
  }
  static void doMemberMenu() {
    while(true) {
      System.out.println("1. 회원 등록");
      System.out.println("2. 회원 목록");
      System.out.println("3. 회원 상세 보기");
      System.out.println("4. 회원 변경");
      System.out.println("5. 회원 삭제");
      System.out.println("0. 이전 메뉴");
      int MenuNo = Prompt.inputInt("회원> ");
     switch (MenuNo) {
       case 1: memberHandler.add(); break ;
       case 2: memberHandler.list(); break;
       case 3: memberHandler.detail();break;
       case 4: memberHandler.update(); break;
       case 5: memberHandler.delete(); break;
       case 0: return;
       default:
         System.out.println("무효한 메뉴 번호입니다.");
         
      }
     
     
     
     
     System.out.println();
   }
  }
  
  
  static void doProjectMenu() {
    while(true) {
      System.out.println("1. 프로젝트 등록");
      System.out.println("2. 프로젝트 목록");
      System.out.println("3. 프로젝트 상세 보기");
      System.out.println("4. 프로젝트 변경");
      System.out.println("5. 프로젝트 삭제");
      System.out.println("0. 이전 메뉴");
      int MenuNo = Prompt.inputInt("프로젝트 > " );
     switch (MenuNo) {
       case 1: projectHandler.add(); break;
       case 2: projectHandler.list(); break;
       case 3: projectHandler.detail(); break ;
       case 4: projectHandler.update();;break;
       case 5: projectHandler.delete(); break ;
       case 0: return;
       default:
         System.out.println("무효한 메뉴 번호입니다.");
         
      }
     
     
     
     
     System.out.println();
   }
  }  
  
  static void doTaskMenu() {
    while(true) {
      System.out.println("1. 작업 등록");
      System.out.println("2. 작업 목록");
      System.out.println("3. 작업 상세 보기");
      System.out.println("4. 작업 변경");
      System.out.println("5. 작업 삭제");
      System.out.println("0. 이전 메뉴");
      int MenuNo = Prompt.inputInt("작업> ");
     switch (MenuNo) {
       case 1:  taskHandler.add(); break;
       case 2:  taskHandler.list(); break ;
       case 3:  taskHandler.detail(); break;
       case 4:  taskHandler.update(); break;
       case 5:  taskHandler.delete(); break;
       case 0: return;
       default:
         System.out.println("무효한 메뉴 번호입니다.");
         
      }
     System.out.println();
   }
  }
  static int doMainMenu() {
    System.out.println("메인----------------------");
    System.out.println("1.게시판");
    System.out.println("2.회원");
    System.out.println("3.프로젝트");
    System.out.println("4.작업");
    System.out.println("0.종료!");
    return Prompt.inputInt("메인> ");
  }
  
  
  
  
  
  
  
}














