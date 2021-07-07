package pms01b;

import java.util.Scanner;

public class Test1 {
/*
Q1.

```console
[회원]
번호? 101  <== 사용자가 101을 입력한다. 아래도 마찬가지다.
이름? 홍길동
이메일? hong@test.com
암호? 1111
사진? hong.png
전화? 010-1111-2222
--------------------------------
번호: 101
이름: 홍길동
이메일: hong@test.com
암호: 1111
사진: hong.png
전화: 010-1111-2222
가입일: 2020-03-05   <== 가입일은 회원 정보를 입력 받은 시간을 보관했다가 출력한다.
```
*/
  public static void main(String[] args) {
    java.util.Date today = new java.util.Date();
    Scanner sc = new Scanner(System.in);
    System.out.println("번호?");
    int no= sc.nextInt();
    
   sc.nextLine();
    
    System.out.println("이름?");
    String name = sc.nextLine();
    
    System.out.println("이메일");
    String email = sc.nextLine();
    
    System.out.println("암호");
    String password = sc.nextLine();
    
   // sc.nextLine();
    System.out.println("사진");
    String pic = sc.nextLine();
    System.out.println("전화");
    String telno = sc.nextLine();
    
  //  sc.nextLine();
    System.out.printf("번호 : %d , 이름: %s 이메일: %s 암호: %s 사진: %s 전화: %s",no,name,email,
        password,pic,telno);
    
    System.out.printf(" 가입일 : %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", today);
    
    sc.close();
  }

}
