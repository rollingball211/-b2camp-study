// inner class : 바깥 클래스의 스태틱 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B {
  // 클래스 멤버
  static int v1 = 10;
  static void m1() {}


  class X {
 

    void test() {
      // 같은 클래스 멤버 접근 가능
      // 바깥 클래스든 패키지 멤버 클래스든 스태틱 멤버를 사용할 떄는
      // 다음과 같이 클래스 이름으로 해당 멤버를 사용함.
      System.out.println(B.v1);
      B.m1();
      System.out.println("-------------------------");

      //중첩 클래스에서 바깥 클래스의 스태틱 멤버에 접근할 때는
      //바깥 클래스 이름을 생략할 수 있다.
      //why?
      // 중첩 클래스도 바깥 클래스의 멤버이기 떄문에
      //(X도 v1,m1처럼 바깥 클래스의 멤버)
      // 같은 멤버에 접근할 떄는 클래스명 생략 가능
      System.out.println(v1);
      m1();
      System.out.println("-------------------------");


 

    

      
    }
  }
}

public class Exam0210 {

  public static void main(String[] args) {
    B outer = new B();

    B.X obj = outer.new X();
    obj.test();

    System.out.println("=================================");

    System.out.println(B.v1);
  }

}
