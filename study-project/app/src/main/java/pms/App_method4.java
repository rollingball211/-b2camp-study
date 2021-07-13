package pms;

import java.sql.Date;
import java.util.Scanner;

//1) 변경 준비 
//2) 사용자에게 명령 프롬프트 출력
//3) 사용자의 명령을 입력 받아 출력
//4) 명령을 입력 받아 출력하는 것을 무한 반복
//5) exit나 quit 명령을 입력하면 반복 실행 중지
//6) /member/add와 /member/list 명령을 구분해 보자!
//7) /member/add 명령 처리
//8) /member/list 명령 처리
//9) /project/add  명령 처리
//10) /project/list 명령 처리
//11) /task/add 명령 처리
//12) /task/list 명령 처리

//1)메소드 이용해 /member/add 넣기
//2)메소드 이용하여 /member/list 넣기
//3)메소드 => add/project
//4)메소드 => project/list
//5)메소드 => taskadd/tasklist
//6)메소드 => 사용자로부터 값을 입력받는 코드 =>prompt
//7) prompt()를 호출할때 사용자에게 출력할 프롬프트 메시지를 설정하도록 변경
//8) 명령어뿐만 아니라 사용자로부터 입력을 받는 기능을 모두 prompt()를 사용하여 처리
// => prompt()를 호출할 때 넘어온 프롬프트 메세지 값을 arguments로 받음
// => prompt(0는 호출할대 넘어온 프롬프트 메세지 값을 파라미터로 받음.
//9) prompt()가 작업한 결과를 클래스 변수에 담지 말고 호출자에게 리턴한다.
public class App_method4 {
  static Scanner keyboardScan = new Scanner(System.in);

  // 회원 정보
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] registeredDate = new Date[LENGTH];
  static int size = 0;
  
//프로젝트 정보
  static final int PROJECT_LENGTH = 1000;
  static int[] pNo = new int[PROJECT_LENGTH];
  static String[] pTitle = new String[PROJECT_LENGTH];
  static  String[] pContent = new String[PROJECT_LENGTH];
  static Date[] pStartDate = new Date[PROJECT_LENGTH];
  static Date[] pEndDate = new Date[PROJECT_LENGTH];
  static String[] pOwner = new String[PROJECT_LENGTH];
  static String[] pMembers = new String[PROJECT_LENGTH];
  static int pSize = 0;

  // 작업 정보
  static final int TASK_LENGTH = 100;
  static int[] tNo = new int[TASK_LENGTH];
  static String[] tContent = new String[TASK_LENGTH];
  static Date[] tDeadline = new Date[TASK_LENGTH];
  static String[] tOwner = new String[TASK_LENGTH];
  static int[] tStatus = new int[TASK_LENGTH];
  static int tSize = 0;
  

 
  public static void main(String[] args) {
    
    while (true) {
    String input =  promptString("명령> ");
      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        addMember();
      } else if (input.equals("/member/list")) {
        memberList();
        
        } else if (input.equals("/project/add")) {
        addProject();

      }  else if (input.equals("/project/list")) {
        projectList();

      }  else if (input.equals("/task/add")) {
        addTask();

      }  else if (input.equals("/task/list")) {
       
        taskList();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    keyboardScan.close();
  }

  static void addMember() {
    System.out.println("[회원 등록]");
    
    //String input = prompt("번호?");
    no[size] = promptInt("번호?");
    name[size] = promptString("이름? ");
    email[size] = promptString("이메일? ");
    password[size] = promptString("암호? ");
    photo[size] = promptString("사진? ");
    tel[size] = promptString("전화번호?");
    registeredDate[size] = new Date(System.currentTimeMillis());

    size++;

    
  }
  static void memberList() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      // 번호, 이름, 이메일, 전화, 가입일
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], name[i], email[i], tel[i], registeredDate[i]);
  }
}
  
 static void addProject() {
   System.out.println("[프로젝트 등록]");

   pNo[pSize] = promptInt("번호? ");
   pTitle[pSize] = promptString("프로젝트 이름 ");
   pContent[pSize] =promptString("프로젝트 내용 ");
   pStartDate[pSize] = promptDate("시작일 ");
   pEndDate[pSize] = promptDate("종료일 ");
   pOwner[pSize] = promptString("만든이 ");
   pMembers[pSize] = promptString("팀원 ");

   pSize++;
 }
 static void projectList() {
   System.out.println("[프로젝트 목록]");
   for (int i = 0; i < pSize; i++) {
     // 번호, 프로젝트명, 시작일, 종료일, 만든이
     System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
         pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
  }
 }
static void addTask() {
  System.out.println("[작업 등록]");

  tNo[tSize] = promptInt("번호? ");
  tContent[tSize] = promptString("내용");
  tDeadline[tSize] = promptDate("마감일?  ");
  System.out.println("상태?");
  System.out.println("0: 신규");
  System.out.println("1: 진행중");
  System.out.println("2: 완료");
  tStatus[tSize] = promptInt(">");
  tOwner[tSize] =promptString("담당자");

  tSize++;
}
static void taskList() {
  System.out.println("[작업 목록]");

  for (int i = 0; i < tSize; i++) {
    String stateLabel = null;
    switch (tStatus[i]) {
      case 1:
        stateLabel = "진행중";
        break;
      case 2:
        stateLabel = "완료";
        break;
      default:
        stateLabel = "신규";
    }
    // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
    System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
   tNo[i], tContent[i], tDeadline[i], stateLabel, tOwner[i]);
  }
}
//prompt();
//-사용자로부터 문자열을 입력 받는 기능을 수행한다.
//- 파라미터: 
//      title - 프롬프트의 메시지

static String promptString(String title) {
  System.out.print(title);
  return keyboardScan.nextLine();
}
static int promptInt(String title) {
  System.out.println(title);
  return Integer.parseInt(keyboardScan.nextLine());
}
static Date promptDate(String title) {
  System.out.println(title);
  return Date.valueOf(keyboardScan.nextLine());
}
 }