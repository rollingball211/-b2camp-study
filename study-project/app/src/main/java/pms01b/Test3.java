package pms01b;

import java.util.Scanner;

public class Test3 {
/*
```console
[작업]
프로젝트? 미니 프로젝트 관리 시스템 개발
번호? 1
내용? 요구사항 수집
완료일? 2020-1-20
상태?
0: 신규
1: 진행중
2: 완료
> 1
담당자? 홍길동
--------------------------------
프로젝트: 미니 프로젝트 관리 시스템 개발
번호: 1
내용: 요구사항 수집
완료일: 2020-01-20
상태: 진행중
담당자: 홍길동
```*/
  public static void main(String[] args) {
   Scanner sc = new Scanner (System.in);
   java.util.Date today = new java.util.Date();
  
   System.out.println("프로젝트 이름을 입력해주세요 : ");
   String pname= sc.nextLine();
   
   System.out.println("번호를 입력해 주세요");
   int pno = sc.nextInt();
   sc.nextLine();
   

   System.out.println("완료일");
   String completeDay = sc.nextLine();
   
   System.out.println("숫자를 입력해 주세요 ");
   System.out.println("0:신규");
   System.out.println("1:진행중");
   System.out.println("2.완료");
   System.out.println(">");
   int number  = sc.nextInt();
   
   sc.nextLine();
   
   System.out.println("담당자?");
   String supervisor = sc.nextLine();
   
   
   System.out.printf("프로젝트 이름: %s \n",pname);
   System.out.printf("프로젝트 번호: %d \n",pno);
   System.out.printf("명령 완료 시간:%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n",today);
   System.out.println("완료일 " + completeDay);
   System.out.println("상태:");
    switch(number) {
     case 0:
       System.out.println("신규 프로젝트");
       break;
     case 1: 
       System.out.println("진행 프로젝트");
     case 2:
       System.out.println("완료된 프로젝트");
       break;
   }
    System.out.printf("담당자 %s : \n",supervisor);
    
    sc.close();
  }

}
