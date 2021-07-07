package pms01b;

import java.util.Scanner;

public class Test2 {
/*
 번호는 int 변수에 받고, 시작일과 종료일은 java.sql.Date 변수에 받는다.
번호가 숫자가 아니면 예외가 발생할 것이다.
시작일과 종료일이 `yyyy-MM-dd` 형식이 아니면 예외가 발생할 것이다.

```console
[프로젝트]
번호? 1201
프로젝트명? 미니 프로젝트 관리 시스템 개발
내용? 소규모 팀을 위한 프로젝트 관리 시스템을 개발한다.
시작일? 2020-1-1
종료일? 2020-12-31
만든이? 임꺽정
팀원? 홍길동,김구,유관순,안중근,윤봉길
--------------------------------
번호: 1201
프로젝트명: 미니 프로젝트 관리 시스템 개발
내용: 소규모 팀을 위한 프로젝트 관리 시스템을 개발한다.
시작일: 2020-01-01
종료일: 2020-12-31
만든이: 임꺽정
팀원: 홍길동,김구,유관순,안중근,윤봉길
```
 */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("번호?");
    int no= sc.nextInt();
    
   sc.nextLine();
    
    System.out.println("프로젝트명?");
    String pname = sc.nextLine();
    
    System.out.println("내용");
    String memo = sc.nextLine();
    
  
    System.out.println("시작일");
    String sDay= sc.nextLine();
    
    System.out.println("종료일 ");
    String eDay = sc.nextLine();
    
   
   // sc.nextLine();
    
    System.out.println("만든이");
    String author = sc.nextLine();
    System.out.println("팀원");
    String TeamMate= sc.nextLine();
    
  //  sc.nextLine();
    System.out.printf("번호 : %d , 프로젝트명: %s 내용: %s \n",no,pname,memo);
    System.out.println("시작일: " + sDay);
    System.out.println("종료일: " + eDay);
     System.out.printf("만든이: %s, 팀원: %s ",author,TeamMate);
    
     sc.close();
    
    
  }

}
