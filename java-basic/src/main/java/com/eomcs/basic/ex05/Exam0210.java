// Stack 클래스 사용법 
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;

public class Exam0210 {

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
  }

}

