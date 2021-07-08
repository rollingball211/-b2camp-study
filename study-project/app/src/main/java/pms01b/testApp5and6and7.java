package pms01b;

import java.util.Date;
import java.util.Scanner;

public class testApp5and6and7 {
  /*
  1)배열 사용 전
  2)배열 사용 후
  3)while
  4)for
  5)변수에 담아 사용
  6)조회용 final
  7)특정조건에 따라 반복 멈춤
  8)날짜 출력형식 yyyy-mm-dd 변경.
*/
 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int i =0;
    final int MAX_VALUE = 100;
    int size =0;
    int [] no = new int[MAX_VALUE];
    String [] name = new String[MAX_VALUE];
    String [] email = new String[MAX_VALUE];
    String [] password = new String[MAX_VALUE];
    String [] photo = new String[MAX_VALUE];
    String [] tel = new String[MAX_VALUE];
    Date [] registeredDate = new Date[MAX_VALUE];
    
    
    
    
    
    
    for (i =0; i<MAX_VALUE; i++) {
    System.out.println("[회원]");
    System.out.print("번호? ");
    no[i] = Integer.parseInt(sc.nextLine());
    System.out.print("이름? ");
    name[i] = sc.nextLine();
    System.out.print("이메일? ");
    email[i] = sc.nextLine();
    System.out.print("암호? ");
    password[i] = sc.nextLine();
    System.out.print("사진? ");
    photo[i] = sc.nextLine();
    System.out.print("전화? ");
    tel[i] = sc.nextLine();
    registeredDate[i] = new Date();
    size++;
    
    System.out.println("추가로 입력하시겠습니까? (Y/N)");
    String answer = sc.nextLine();
    if(answer.equalsIgnoreCase("N")) {
      break;
      }
    
    System.out.println();
   
  }
    

    sc.close(); // 데이터 입출력이 끝났으면 도구를 닫는다.
    
    for (i =0; i<size; i++) {
    System.out.println("--------------------------------");

    System.out.println("번호: " + no[i]);
    System.out.println("이름: " + name[i]);
    System.out.println("이메일: " + email[i]);
    System.out.printf("암호: %s\n", password[i]);
    System.out.printf("사진: %s\n", photo[i]);
    System.out.printf("전화: %s\n", tel[i]);
    System.out.printf("가입일: %s\n", registeredDate[i]);
    
    }
  }
 }
