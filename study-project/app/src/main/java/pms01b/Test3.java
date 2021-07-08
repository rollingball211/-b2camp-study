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
   
   int size =0 ;
   int i =0;
   final int MAX_LENGTH = 100;
   int [] pno = new int[MAX_LENGTH];
   String [] pname = new String[MAX_LENGTH];
   
   String [] contents = new String[MAX_LENGTH];
   String [] creator = new String[MAX_LENGTH];
   String [] teamMate = new String[MAX_LENGTH];
   String [] completeDate = new String[MAX_LENGTH];
   
   int [] number = new int[MAX_LENGTH];
   String [] supervisor = new String[MAX_LENGTH];
   
   java.util.Date today = new java.util.Date();
  
   for(i=0;i<MAX_LENGTH;i++) {
   size++;
   System.out.println("프로젝트 이름을 입력해주세요 : ");
   pname[i]= sc.nextLine();
   
   System.out.println("번호를 입력해 주세요");
   pno[i] = Integer.parseInt(sc.nextLine());
   

   System.out.println("완료일");
   completeDate[i] = sc.nextLine();
   
   
   System.out.println("숫자를 입력해 주세요");
   System.out.println("0:신규");
   System.out.println("1:진행중");
   System.out.println("2.완료");
   System.out.println(">");
   number[i] = Integer.parseInt(sc.nextLine());
   
   System.out.println("담당자?");
   supervisor[i] = sc.nextLine();

   System.out.println("계속 입력하시겟습니까? (Y/N)");
   String input = sc.nextLine();
   if (input.equalsIgnoreCase("n")){
     break;
   }
   System.out.println();
   
  
   }
   
   sc.close();
   
   
   for(i=0; i<size; i++) {
   System.out.println("프로젝트 이름: "  + pname[i]);
   System.out.println("프로젝트 번호: "+ pno[i]);
   System.out.println("완료일:  " + completeDate[i]);
   System.out.println("상태:");
    switch (number[i]) {
     case 0:
       System.out.println("신규 프로젝트");
       break;
     case 1: 
       System.out.println("진행 프로젝트");
       break;
     case 2:
       System.out.println("완료된 프로젝트");
       break;
   }
    System.out.printf("담당자 \n: " + supervisor[i]);
   }
   
  }

}
