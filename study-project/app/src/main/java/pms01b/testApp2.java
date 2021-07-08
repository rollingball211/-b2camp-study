package pms01b;

import java.util.Date;
import java.util.Scanner;

public class testApp2 {

  public static void main(String[] args) {
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
   
      
      int [] no = new int[5];
      String [] name = new String[5];
      String [] email = new String[5];
      String [] password = new String[5];
      String [] photo = new String[5];
      String [] tel = new String[5];
      Date [] registeredDate = new Date[5];
      
      
      
      System.out.println("[회원]");
   

      Scanner sc= new Scanner(System.in);

      System.out.print("번호? ");
      no[0] = Integer.parseInt(sc.nextLine());
      System.out.print("이름? ");
      name[0] = sc.nextLine();
      System.out.print("이메일? ");
      email[0] = sc.nextLine();
      System.out.print("암호? ");
      password[0] = sc.nextLine();
      System.out.print("사진? ");
      photo[0] = sc.nextLine();
      System.out.print("전화? ");
      tel[0] = sc.nextLine();
      registeredDate[0] = new Date();
      
      System.out.print("번호? ");
      no[1] = Integer.parseInt(sc.nextLine());
      System.out.print("이름? ");
      name[1] = sc.nextLine();
      System.out.print("이메일? ");
      email[1] = sc.nextLine();
      System.out.print("암호? ");
      password[1] = sc.nextLine();
      System.out.print("사진? ");
      photo[1] = sc.nextLine();
      System.out.print("전화? ");
      tel[1] = sc.nextLine();
      registeredDate[1] = new Date();
      
      System.out.print("번호? ");
      no[2] = Integer.parseInt(sc.nextLine());
      System.out.print("이름? ");
      name[2] = sc.nextLine();
      System.out.print("이메일? ");
      email[2] = sc.nextLine();
      System.out.print("암호? ");
      password[2] = sc.nextLine();
      System.out.print("사진? ");
      photo[2] = sc.nextLine();
      System.out.print("전화? ");
      tel[2] = sc.nextLine();
      registeredDate[2] = new Date();
      
      System.out.print("번호? ");
      no[3] = Integer.parseInt(sc.nextLine());
      System.out.print("이름? ");
      name[3] = sc.nextLine();
      System.out.print("이메일? ");
      email[3] = sc.nextLine();
      System.out.print("암호? ");
      password[3] = sc.nextLine();
      System.out.print("사진? ");
      photo[3] = sc.nextLine();
      System.out.print("전화? ");
      tel[3] = sc.nextLine();
      registeredDate[3] = new Date();
      
      System.out.print("번호? ");
      no[4] = Integer.parseInt(sc.nextLine());
      System.out.print("이름? ");
      name[4] = sc.nextLine();
      System.out.print("이메일? ");
      email[4] = sc.nextLine();
      System.out.print("암호? ");
      password[4] = sc.nextLine();
      System.out.print("사진? ");
      photo[4] = sc.nextLine();
      System.out.print("전화? ");
      tel[4] = sc.nextLine();
      registeredDate[4] = new Date();

      sc.close(); // 데이터 입출력이 끝났으면 도구를 닫는다.

      System.out.println("--------------------------------");

      System.out.println("번호: " + no[0]);
      System.out.println("이름: " + name[0]);
      System.out.println("이메일: " + email[0]);
      System.out.printf("암호: %s\n", password[0]);
      System.out.printf("사진: %s\n", photo[0]);
      System.out.printf("전화: %s\n", tel[0]);
      System.out.printf("가입일: %s\n", registeredDate[0]);
      
      System.out.println("--------------------------------");

      System.out.println("번호: " + no[1]);
      System.out.println("이름: " + name[1]);
      System.out.println("이메일: " + email[1]);
      System.out.printf("암호: %s\n", password[1]);
      System.out.printf("사진: %s\n", photo[1]);
      System.out.printf("전화: %s\n", tel[1]);
      System.out.printf("가입일: %s\n", registeredDate[1]);
      
      System.out.println("--------------------------------");

      System.out.println("번호: " + no[2]);
      System.out.println("이름: " + name[2]);
      System.out.println("이메일: " + email[2]);
      System.out.printf("암호: %s\n", password[2]);
      System.out.printf("사진: %s\n", photo[2]);
      System.out.printf("전화: %s\n", tel[2]);
      System.out.printf("가입일: %s\n", registeredDate[2]);
      
      
      System.out.println("--------------------------------");

      System.out.println("번호: " + no[3]);
      System.out.println("이름: " + name[3]);
      System.out.println("이메일: " + email[3]);
      System.out.printf("암호: %s\n", password[3]);
      System.out.printf("사진: %s\n", photo[3]);
      System.out.printf("전화: %s\n", tel[3]);
      System.out.printf("가입일: %s\n", registeredDate[3]);
      
      System.out.println("--------------------------------");

      System.out.println("번호: " + no[4]);
      System.out.println("이름: " + name[4]);
      System.out.println("이메일: " + email[4]);
      System.out.printf("암호: %s\n", password[4]);
      System.out.printf("사진: %s\n", photo[4]);
      System.out.printf("전화: %s\n", tel[4]);
      System.out.printf("가입일: %s\n", registeredDate[4]);
    }
}
