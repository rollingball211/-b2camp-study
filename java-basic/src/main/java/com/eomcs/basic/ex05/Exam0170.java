// Stack 클래스 사용법 - Iterator 사용
package com.eomcs.basic.ex05;

import java.util.Stack;

public class Exam0170 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    
    
    //Stack도 Iterable 구현체
    //다음과 같이 for(:) 문 사용 가능
    // => 내부적으로는 iterator()를 호출하여 Iterator를 꺼낸 후에
    // 이 Iterator을 통해 값을 꺼냄
    
    for (String s : stack) {
      System.out.println(s);
    }

  }

}

