package pms;
/*
1)입출력 정보를 다루는 메서드를 별도의 클래스로 분류
2)회원등록 정보를 다루는 메서드를 별도의 클래스로 분류
3)프로젝트 정보를 다루는 메서드를 별도의 클래스로 분류
4)작업 정보를 다루는 메서드를 별도의 클래스로 분류
5)키보드 스캐너를 닫는 일은 그 스캐너를 갖고 있는 클래스에서 수행한다.

*/
public class App {

  //static Scanner keyboardScan = new Scanner(System.in);

  // 회원 정보
  
  // 프로젝트 정보
  

  // 작업 정보

  
  public static void main(String[] args) {

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        // 메서드로 분리한 코드를 실행하기(메서드 호출)
        // => 메서드명();
        MemberHandler.add();

      } else if (input.equals("/member/list")) {
        MemberHandler.list();

      }  else if (input.equals("/project/add")) {
        ProjectHandler.addProject();

      }  else if (input.equals("/project/list")) {
        ProjectHandler.listProjects();

      }  else if (input.equals("/task/add")) {
        TaskHandler.addTask();

      }  else if (input.equals("/task/list")) {
        TaskHandler.listTasks();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    Prompt.close();
  }

 

 


}












