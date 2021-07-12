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
//8) /member/list 명령 처리.
public class App1_h {

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
      break;
      }else {
      System.out.println("실행할 수 없는 명령입니다.");
      }
    System.out.println(input);
  

    }
    sc.close();
  }


}
