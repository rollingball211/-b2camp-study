package pms01b;

import java.util.Scanner;

public class NextTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("sc.next");
    String test1 = sc.next();
    
    sc.nextLine();
    
    System.out.println("sc.nextline");
    String test2 = sc.nextLine();
    
    System.out.println(test1);
    System.out.println(test2);
    
    
  }

}
