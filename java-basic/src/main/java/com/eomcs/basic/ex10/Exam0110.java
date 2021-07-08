package com.eomcs.basic.ex10;

public class Exam0110 {

  public static void main(String[] args) {
    long str  = System.currentTimeMillis();
    System.out.println(str);
    java.util.Date d= new java.util.Date(str);
    System.out.println(d.toString());
    
    java.sql.Date sqld = new java.sql.Date(str);
    System.out.println(sqld);
  }

}
