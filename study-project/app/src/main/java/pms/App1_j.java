package pms;

import java.sql.Date;
import java.util.Scanner;

//1) 변경 준비
//2) 사용자에게 명령 프롬프트 출력
//3) 사용자의 명령을 입력 받아 출력
//4) 명령을 입력 받아 출력하는 것을 무한반복함.
//5) exit 이나 quit을 입력하면 반복문 탈출.
//6) /member/add, /member/list 명령 구분 
//7) /member/add 명령 처리
//8) /member/list 명령 처리
//9) /project/add 명령 처리.
//10)/project/list 명령 처리
//11)task/add 명령 처리
//12)task/list 명령 처리
public class App1_j {

  public static void main(String[] args) {
    final int MAX_LENGTH = 100;
    int i =0;
    Scanner sc = new Scanner(System.in);
    
    
    
    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] password = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] tel = new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];
    int size =0 ;
    
 final int PLENGTH = 1000;
    
    int[] pno = new int[PLENGTH];
    String[] title = new String[PLENGTH];
    String[] content = new String[PLENGTH];
    Date[] startDate = new Date[PLENGTH];
    Date[] endDate = new Date[PLENGTH];
    String[] owner = new String[PLENGTH];
    String[] members = new String[PLENGTH];
 
    int[] status = new int[PLENGTH];

 final int LENGTH = 100;
    
    int[] tno = new int[LENGTH];
    String[] tcontent = new String[LENGTH];
    Date[] tdeadline = new Date[LENGTH];
    String[] towner = new String[LENGTH];
    int[] tstatus = new int[LENGTH];
  
    
    int pSize =0 ;
    int tSize =0;
    
    while(true) {
    System.out.print("명령 > ");
    
    String input = sc.nextLine();
    if(input.equals("quit") || input.equals("exit")) {
      System.out.println("명령을 종료합니다.");
     break;
    }else if(input.equals("/member/add")) {
      System.out.println("[회원등록]");
      System.out.println("번호?: ");
      no[size]= Integer.parseInt(sc.nextLine()); 
      System.out.println("이름?: ");
      name[size] = sc.nextLine();
      System.out.println("이메일: ");
      email[size] = sc.nextLine();
      System.out.println("암호: ");
      password[size] = sc.nextLine();
      System.out.println("사진: ");
      photo[size] = sc.nextLine();
      System.out.println("전화: ");
      tel[size] = sc.nextLine();
      registeredDate[size] = new Date(System.currentTimeMillis());
      System.out.println();
      size++;    
      } else if(input.equals("/member/list")) {
      System.out.println("[회원목록]");
      
      for (i=0; i<size; i++) {
        System.out.println("번호: "+ no[i] + 
                           "이름: " + name[i] + 
                           "이메일: " +email[i] + 
                           "암호: "+ password[i]+ 
                           "사진: " + photo[i]+ 
                           "전화: " + tel[i]);
        System.out.printf("가입일: %tY-%1$tm-%1$td\n",registeredDate[i]);
      }
      
      } else if(input.equals("/project/add")) {
        System.out.println("[프로젝트 등록]");
        
        System.out.print("번호? ");
        pno[pSize] = Integer.valueOf(sc.nextLine());

        System.out.print("프로젝트명? ");
        title[pSize] = sc.nextLine();

        System.out.print("내용? ");
        content[pSize] = sc.nextLine();

        System.out.print("시작일? ");
        startDate[pSize] = Date.valueOf(sc.nextLine());

        System.out.print("종료일? ");
        endDate[pSize] = Date.valueOf(sc.nextLine());

        System.out.print("만든이? ");
        owner[pSize] = sc.nextLine();

        System.out.print("팀원? ");
        members[pSize] = sc.nextLine();

        pSize++;
      }else if(input.equals("/project/list")){
        System.out.println("프로젝트 목록");
        for (i = 0; i < pSize; i++) {
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              pno[i], title[i], startDate[i], endDate[i], owner[i]);
        }
      }else if(input.equals("/task/add")) {
        System.out.println("작업 상태");
        System.out.println("상태?");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        status[tSize] = Integer.valueOf(sc.nextLine());

        System.out.print("담당자? ");
        owner[tSize] = sc.nextLine();

        tSize++;
        System.out.println(); // 빈 줄 출력
      
      } else {
      System.out.println("실행할 수 없는 명령입니다.");
      }

  

    }
    sc.close();
  }


}
