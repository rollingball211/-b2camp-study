package com.eomcs.pms.menu;

//MenuItem이 리스너 객체를 실행할 때
//호출할 메서드의 규칙이다.

public interface ActionListener {

  void doAction();
  
  //인터페이스의 메서드는 규칙을 표현하는 것.
  //그래서 추상메서드이다.
  //모두의 접근을 허락하는 public이다 
}
