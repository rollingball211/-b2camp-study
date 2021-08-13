// inner class : 바깥 클래스의 인스턴스 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B4 {

  // 인스턴스 멤버
  int v1 = 10;
  

  class X {
    int v2 = 100;

    void test() {
      int v3 = 1000;

      System.out.println(v3);  //local
      System.out.println(this.v2); //인스턴스 
      System.out.println(B4.this.v1); //바같 객체의 인스턴스 변수
      System.out.println("-------------------------");



    }
  }
}

public class Exam0240 {

  public static void main(String[] args) {
    B4 outer = new B4();
      outer.v1 = 11;

      B4.X x1 = outer.new X();
      x1.test();
      System.out.println("--------------------");

      B4.X x2 = outer.new X();
      x2.test();
      System.out.println("--------------------");

      B4 outer2 = new B4();
      outer2.v1 = 22;

      B4.X x3 = outer2.new X();
      x3.test();
      System.out.println("--------------------");
    }



  }


