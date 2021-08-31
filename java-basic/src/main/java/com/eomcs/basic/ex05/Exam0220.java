// Stack 클래스 사용법 
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;

public class Exam0220 {

  public static void main(String[] args) {
    
    //Dequeue 인터페이스 
    // =double ended queue의 약자
    // 앞 뒤 모두 양방향에서 값을넣고 꺼낼수 있음
    // 큐로도 사용할수 있고 스택으로도 사용할수 잇음
    // 큐 스택 둘다 사용할수 있도록 queue와 stack 사용법을 모두 정의한 인터페이스
    
    //dequeue 구현체
    ArrayDeque<String> stack = new ArrayDeque<>();
    
    
    
    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    
    
    while (!stack.isEmpty()) {
      
    }
    
    //여기서 잠깐! 
    /*
       Iteator 설계 기법의 목적
       - 데이터 조회 방식(LIFO, FIFO)에 상관없이
        일관된 방법으로 데이터를 조회할수 있게 도와줌
        스택처럼 
        
     */
  }

}

