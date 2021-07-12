package pms;

import java.util.Scanner;

//1) 변경 준비
//2) 사용자에게 명령 프롬프트 출력
//3) 사용자의 명령을 입력 받아 출력
//4) 명령을 입력 받아 출력하는 것을 무한반복함.
//5) exit 이나 quit을 입력하면 반복문 탈출.
public class App1_e {

  public static void main(String[] args) {
    final int MAX_LENGTH = 100;
    int i =0;
    Scanner sc = new Scanner(System.in);
    
    while(true) {
    System.out.print("명령 > ");
    
    String input = sc.nextLine();
    if(input.equals("quit") || input.equals("exit")) {
      System.out.println("명령을 종료합니다.");
     break;
    }
    System.out.println(input);
  
  
    }
 /*
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

 */
  }


}
