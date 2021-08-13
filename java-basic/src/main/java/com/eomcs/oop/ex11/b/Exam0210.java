// static nested class : 다른 멤버에 접근하기
package com.eomcs.oop.ex11.b;

class B {
  // 클래스 멤버
  static int v1;
  static void m1() {}

  // 인스턴스 멤버
  int v2;
  void m2() {}

  static class X {
    void test() {
      // 같은 클래스 멤버 접근 가능
      // 일반적으로 클래스의 스태틱 멤버(필드, 메서드)에 접근 할 때는
      // 다음과 같이 그 클래스의 이름을 명시해야 함.
      B.v1 = 100;
      B.m1();

      /*
       * 클래스 X도 B클래스의 멤버 
       * B클래스의 멤버에 접근할 때는 다음과 같이 바깥 클래스 이름 생략 가능
       */
      // 바깥 클래스 이름 생략 가능
      v1 = 200; 
      m1(); 

      // 스태틱 멤버는 인스턴스 멤버 접근 불가능!
      //      v2 = 100; // 컴파일 오류!
      //      m2(); // 컴파일 오류!
    }
  }
}

public class Exam0210 {

  public static void main(String[] args) {
    B.X obj = new B.X();
    obj.test();

    System.out.println(B.v1);

  }

}
