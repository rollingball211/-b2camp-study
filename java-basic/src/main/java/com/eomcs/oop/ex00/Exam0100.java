package com.eomcs.oop.ex00;

public class Exam0100 {
 
  public static void main(String[] args) {
    //스태틱 변수 테스트.
    test1();
    
  }
  
  static void test1() {
   //스태틱 변수 사용
    // => 최초로 스태틱 멤버(변수,메서드)를 사용하는 시점에 클래스가 로딩됨.
    
    //=> 클래스가 로딩된 후 즉시 자동으로 스태틱 변수가 Method area 영역에 생성
    
    //=> 클래스가 언로드가 될때 스태틱 변수 제거됨
    // 클래스가 언로드 될 때는 JVM이 종료될 때다.
    Test.a = 100;
    //최초로 사용하는 시점에 Test 클래스 로딩.
  }
  
  static void test2() {
    Test.a = 200;
    
    
  }
}
