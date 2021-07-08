package pms01b;

import java.sql.Date;
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
    int i = 0;
    final int MAX_LENGTH =100;
    int size = 0;
    
    int [] no = new int[MAX_LENGTH];
    String [] pname = new String[MAX_LENGTH];
    String [] contents = new String[MAX_LENGTH];
    String [] creator = new String[MAX_LENGTH];
    String [] teamMate = new String[MAX_LENGTH];
    Date [] startDate = new Date[MAX_LENGTH];
    Date [] endDate = new Date[MAX_LENGTH];

    Scanner sc = new Scanner(System.in);
    
    for (i=0; i<MAX_LENGTH; i++) {
    size ++;
    System.out.println("번호?");
    no[i]= Integer.parseInt(sc.nextLine());
    
    System.out.println("프로젝트명?");
    pname[i] = sc.nextLine();
    
    System.out.println("내용");
    contents[i] = sc.nextLine();
    
 
    System.out.print("시작일? ");
    startDate[i] = Date.valueOf(sc.nextLine());

    System.out.print("종료일? ");
    endDate[i] = Date.valueOf(sc.nextLine());

   
   // sc.nextLine();
    
    System.out.println("만든이");
    creator[i] = sc.nextLine();
    System.out.println("팀원");
    teamMate[i]= sc.nextLine();
    
    System.out.println("추가로 입력하시겠습니까? (Y/N)");
    String answer = sc.nextLine();
    if(answer.equalsIgnoreCase("N")) {
      break;
      }
    System.out.println();
    }
    
    for(i=0; i<size; i++) {
      System.out.println("번호 : " + no[i]
                        + "프로젝트명: " + pname[i]
                        + " 내용: " + contents[i]
                        +" 시작일: " + startDate[i]
                        +" 종료일: " + endDate[i]
                        +" 만든이: " + creator[i]
                        +" 팀원: "   + teamMate[i]
                        );
    }
   
    
     sc.close();
    
    
  }

}
