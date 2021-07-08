package com.eomcs.basic.ex10;

import java.util.Scanner;

public class Exam0120 {

  public static void main(String[] args) {
    java.util.Date d= new java.util.Date(); //Date 객체를 만드는 순간의 시각을 저장함.
    System.out.println(d.toString());
    Scanner sc = new Scanner(System.in);
    System.out.printf("%tY-%tm-%td",d,d,d);
    System.out.printf("%tY-%1$tm-%1$td",d,d,d);
    
   //new  java.sql.Date(밀리초)
    //java.sql.Date.ValueIf*(날짜 문자열);
    
    int no = Sc.nextInt();
    
   sc.nextLine();
  }

}
