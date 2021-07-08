package pms01b;

import java.util.Date;
import java.util.Scanner;
public class testApp1 {
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
   
    int no1,no2,no3,no4,no5;
    String name1,name2,name3,name4,name5;
    String email1,email2,email3,email4,email5;
    String password1,password2,password3,password4,password5;
    String photo1,photo2,photo3,photo4,photo5;
    String tel1,tel2,tel3,tel4,tel5;
    Date registeredDate1,registeredDate2,registeredDate3,registeredDate4,registeredDate5;
    
    
    
    System.out.println("[회원]");
 

    Scanner sc= new Scanner(System.in);

    System.out.print("번호? ");
    no1 = Integer.parseInt(sc.nextLine());
    System.out.print("이름? ");
    name1 = sc.nextLine();
    System.out.print("이메일? ");
    email1 = sc.nextLine();
    System.out.print("암호? ");
    password1 = sc.nextLine();
    System.out.print("사진? ");
    photo1 = sc.nextLine();
    System.out.print("전화? ");
    tel1 = sc.nextLine();
    registeredDate1 = new Date();
    
    System.out.print("번호? ");
    no2 = Integer.parseInt(sc.nextLine());
    System.out.print("이름? ");
    name2 = sc.nextLine();
    System.out.print("이메일? ");
    email2 = sc.nextLine();
    System.out.print("암호? ");
    password2 = sc.nextLine();
    System.out.print("사진? ");
    photo2 = sc.nextLine();
    System.out.print("전화? ");
    tel2 = sc.nextLine();
    registeredDate2 = new Date();
    
    System.out.print("번호? ");
    no3 = Integer.parseInt(sc.nextLine());
    System.out.print("이름? ");
    name3 = sc.nextLine();
    System.out.print("이메일? ");
    email3 = sc.nextLine();
    System.out.print("암호? ");
    password3 = sc.nextLine();
    System.out.print("사진? ");
    photo3 = sc.nextLine();
    System.out.print("전화? ");
    tel3 = sc.nextLine();
    registeredDate3 = new Date();
    
    
    System.out.print("번호? ");
    no4 = Integer.parseInt(sc.nextLine());
    System.out.print("이름? ");
    name4 = sc.nextLine();
    System.out.print("이메일? ");
    email4 = sc.nextLine();
    System.out.print("암호? ");
    password4 = sc.nextLine();
    System.out.print("사진? ");
    photo4 = sc.nextLine();
    System.out.print("전화? ");
    tel4 = sc.nextLine();
    registeredDate4 = new Date();
    
    
    System.out.print("번호? ");
    no5 = Integer.parseInt(sc.nextLine());
    System.out.print("이름? ");
    name5 = sc.nextLine();
    System.out.print("이메일? ");
    email5 = sc.nextLine();
    System.out.print("암호? ");
    password5 = sc.nextLine();
    System.out.print("사진? ");
    photo5 = sc.nextLine();
    System.out.print("전화? ");
    tel5 = sc.nextLine();
    registeredDate5 = new Date();

    sc.close(); // 데이터 입출력이 끝났으면 도구를 닫는다.

    System.out.println("--------------------------------");

    System.out.println("번호: " + no1);
    System.out.println("이름: " + name1);
    System.out.println("이메일: " + email1);
    System.out.printf("암호: %s\n", password1);
    System.out.printf("사진: %s\n", photo1);
    System.out.printf("전화: %s\n", tel1);
    System.out.printf("가입일: %s\n", registeredDate1);
    
    System.out.println("--------------------------------");

    System.out.println("번호: " + no2);
    System.out.println("이름: " + name2);
    System.out.println("이메일: " + email2);
    System.out.printf("암호: %s\n", password2);
    System.out.printf("사진: %s\n", photo2);
    System.out.printf("전화: %s\n", tel2);
    System.out.printf("가입일: %s\n", registeredDate2);
    
    System.out.println("--------------------------------");

    System.out.println("번호: " + no3);
    System.out.println("이름: " + name3);
    System.out.println("이메일: " + email3);
    System.out.printf("암호: %s\n", password3);
    System.out.printf("사진: %s\n", photo3);
    System.out.printf("전화: %s\n", tel3);
    System.out.printf("가입일: %s\n", registeredDate3);
    
    
    System.out.println("--------------------------------");

    System.out.println("번호: " + no4);
    System.out.println("이름: " + name4);
    System.out.println("이메일: " + email4);
    System.out.printf("암호: %s\n", password4);
    System.out.printf("사진: %s\n", photo4);
    System.out.printf("전화: %s\n", tel4);
    System.out.printf("가입일: %s\n", registeredDate4);
    
    System.out.println("--------------------------------");

    System.out.println("번호: " + no5);
    System.out.println("이름: " + name5);
    System.out.println("이메일: " + email5);
    System.out.printf("암호: %s\n", password5);
    System.out.printf("사진: %s\n", photo5);
    System.out.printf("전화: %s\n", tel5);
    System.out.printf("가입일: %s\n", registeredDate5);
  }
}


