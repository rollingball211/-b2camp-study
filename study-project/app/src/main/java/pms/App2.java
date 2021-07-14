package pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

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

  // 프로젝트 정보
  static final int PROJECT_LENGTH = 1000;
  static int[] pNo = new int[PROJECT_LENGTH];
  static String[] pTitle = new String[PROJECT_LENGTH];
  static String[] pContent = new String[PROJECT_LENGTH];
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

  static String input;

public static void main(String[] args) {
  
  while (true) {
    String input =  promptString("명령> "); 

    if (input.equals("exit") || input.equals("quit")) {
      System.out.println("안녕!");
      break;
    } else if (input.equals("/member/add")) {
      addMember();

    } else if (input.equals("/member/list")) {
      listMembers();

    }  else if (input.equals("/project/add")) {
      addProject();

    }  else if (input.equals("/project/list")) {
      listProjects();
    }  else if (input.equals("/task/add")) {
      addTask();

    }  else if (input.equals("/task/list")) {
      listTask();

    } else {
      System.out.println("실행할 수 없는 명령입니다.");
    }
    System.out.println();
  }

  keyboardScan.close();
}
static void addMember() {
  System.out.println("[회원 등록]");
      prompt("번호? : ")
      no[size] = Integer.parseInt(input);

      prompt("이름? : ");
      name[size] = input;

      prompt("이메일? : ");
      email[size] = input;

      prompt("암호? : ");
      password[size] = input;

      prompt("사진?: ");
      photo[size] = input;

      prompt("전화?: ");
      tel[size] = input;

      registeredDate[size] = new Date(System.currentTimeMillis());

      size++;
}

static void listMembers() {
  System.out.println("[회원 목록]");
      for (int i = 0; i < size; i++) {
        // 번호, 이름, 이메일, 전화, 가입일
        System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
            no[i], name[i], email[i], tel[i], registeredDate[i]);
      }
}

static void addProject(){
  System.out.println("[프로젝트 등록]");

      promptInt("번호? : ");
      pNo[pSize] = Integer.valueOf(input);

      promptString("프로젝트명? : ");
      pTitle[pSize] = input;

      prompt("내용? : ");
      pContent[pSize] = input;

      prompt("시작일 : ");
      pStartDate[pSize] = Date.valueOf(input);

      prompt("종료일 : ");
      pEndDate[pSize] = Date.valueOf(input);

      prompt("만든이: ");
      pOwner[pSize] = input;

      prompt("팀원 : ");
      pMembers[pSize] = input;

      pSize++;
    
}
static void listProjects(){
  System.out.println("[프로젝트 목록]");
      for (int i = 0; i < pSize; i++) {
        // 번호, 프로젝트명, 시작일, 종료일, 만든이
        System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
            pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
} 
static void addTask() {
  System.out.println("[작업 등록]");

      prompt("번호? : ")
      tNo[tSize] = Integer.parseInt(input);

      prompt("내용? :");
      tContent[tSize] = keyboardScan.nextLine();

      prompt("마감일? :");
      tDeadline[tSize] = Date.valueOf(keyboardScan.nextLine());

      System.out.println("상태?");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      prompt(">");
      tStatus[tSize] = Integer.valueOf(input);

      prompt("담당자? : ")
      tOwner[tSize] = keyboardScan.nextLine();

      tSize++;

}
static void listTask() {
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

static String promptString(String title){
  System.out.print(title);
  return keyboardScan.nextLine();
}
static int promptInt(String title){
  System.out.print(title);
  return Integer.parseInt(keyboardScan.nextLine());
}
static Date promptDate(String title){
  System.out.print(title);
  return Date.valueOf(keyboardScan.nextLine());
}

}
