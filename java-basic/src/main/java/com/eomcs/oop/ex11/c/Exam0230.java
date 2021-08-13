// inner class : 바깥 클래스의 인스턴스 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B3 {

  // 인스턴스 멤버
  int v1 = 10;
  

  class X {
    int v1 = 100;

    void test() {
      int v1 = 1000;
      B.m1();

      System.out.println(v1);  //local
      System.out.println(this.v1); //인스턴스 
      System.out.println(B3.this.v1); //바같 객체의 인스턴스 변수
      System.out.println("-------------------------");



      // this 를 생략하면 항상 가장 가까운 곳부터 찾는다.

      // => inner class 의 가장 큰 특징은 바깥 클래스의 다른 멤버에 손쉽게 접근할 수 있다는 것이다.
      // => 이것이 가능한 이유는 바깥 클래스의 인스턴스 멤버이기 때문이다.
    }
  }
}

public class Exam0230 {

  public static void main(String[] args) {
    B3 outer = new B3();
    outer.v1 =11;
    System.out.println("=================================");

    
    B3.X x1= outer.new X();
    x1.test();
    System.out.println("=================================");

    
    B3.X x2 = outer.new X();
    x2.test();
    System.out.println("=================================");

    
    B3.X x3 = outer.new X();
    x3.test();
    System.out.println("=================================");

  }

}
