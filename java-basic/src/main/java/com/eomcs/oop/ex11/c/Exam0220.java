// inner class : 바깥 클래스의 인스턴스 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B2 {

  // 인스턴스 멤버
  int v2 = 20;
  void m2() {
    System.out.println("B2.V2 = " + B2.this.v2);
  }

  class X {
    void test() {
      //바깥 클래스의 인스턴스 멤버에 접근하려면
      //inner 객체에 보고나된 바깥 객체 주소를 사용해야 함
      //컴파일러가 자동 생성한 바깥 객체 주소를 담는 필드를 사용해야함.
      //문제는 컴파일러가 자동 생성한 필드 일므이 뭔지 모름.
      //그래서 자바는 inner 객체에 보관된 바깥 객체를 가리키기 위해
      //다음의 문법을 제공하고 있다
      
      //바깥 클래스명.this.인스턴스멤버명
      //바깥 객체 접근 가능
      // 인스턴스 멤버에 접근 가능
      // =>   바깥클래스명.this.인스턴스멤버명
      System.out.println(B2.this.v2); 
      B2.this.m2();
      System.out.println("-------------------------");

    }
  }
}

public class Exam0220 {

  public static void main(String[] args) {
    B2 outer = new B2();
    outer.v2 = 100;
    outer.m2();
    
    B2 outer2 = new B2();
    outer2.v2 =200;
    outer.m2();
    
    B2.X inner = outer.new X(); // == new X(Outer); 자동으로 인스턴스 , 생성자 생성.
   
    
    B2.X inner2 = outer2.new X();//= new X(outer2);
    
  }

}
