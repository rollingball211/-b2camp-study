package com.eomcs.oop.ex00;

import com.eomcs.oop.ex00.util.Calculator;

public class Exam0500{

  
  
  public static void main(String[] args) {
    
    new Calculator();
    
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 계산 결과를 담을 변수를 준비한다.
    

    // 메서드를 호출하여 작업을 수행하고,
    // 리턴 결과는 로컬 변수에 저장한다.

     Calculator c1 = new Calculator();
     Calculator c2 = new Calculator();
     
   
     
     c1.plus(2); // 0  + 2
     c2.plus(3);
     
     c1.plus (3);// 2 + 3
     c2.multiple (2);
     
     c1.minus(1);//2 + 3  -1 
     c2.plus( 4);
     
     
     c1.divide(3);//2 + 3 -1 /3
     c2.minus(5);
    System.out.printf("result = %d \n",c1.result);
    
    System.out.printf("result  = %d \n " , c2.result);
  }
  
}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.

