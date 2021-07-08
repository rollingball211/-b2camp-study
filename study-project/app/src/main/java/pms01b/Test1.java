package pms01b;

import java.util.Date;
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

6)조회용으로 사용할 변수라면 final 사용 (상수)
*/
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
    for (i=0; i<MAX_LENGTH;i++) {
      
    size++;
    System.out.println("번호?: ");
    no[i]= Integer.parseInt(sc.nextLine()); 
    System.out.println("이름?: ");
    name[i] = sc.nextLine();
    System.out.println("이메일: ");
    email[i] = sc.nextLine();
    System.out.println("암호: ");
    password[i] = sc.nextLine();
    System.out.println("사진: ");
    photo[i] = sc.nextLine();
    System.out.println("전화: ");
    tel[i] = sc.nextLine();
    registeredDate[i] = new Date();
    System.out.println();
   
    System.out.println("계속 입력하시겠습니까? (Y/N)");
    String input = sc.nextLine();
    if (input.equalsIgnoreCase("n")){
      break;
    }
    System.out.println();
   }
    
   sc.close();
 
for (i=0; i<size; i++) {
  System.out.println("번호: "+ no[i] + 
                     "이름: " + name[i] + 
                     "이메일: " +email[i] + 
                     "암호: "+ password[i]+ 
                     "사진: " + photo[i]+ 
                     "전화: " + tel[i]);
  System.out.printf("가입일: %tY-%1$tm-%1$td\n",registeredDate[i]);
}

 
  }

}
