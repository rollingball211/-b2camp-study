package com.eomcs.pms.handler;

// Generalization을 통해 수퍼 클래스를 정의한 경우 
// 그 수퍼 클래스는 서브 클래스의 공통 분모를 모아두는 용도로 만든 것이다.
// 직접 사용하기 위해 만든 클래스가 아니다.


//List 클래스 
/*
 ArrayList 와 LinkedLikst를 한 타입으로 묶는 일을 함
 상속해 줄 필드는 없다
 상속해 줄 메서드도 없다
 다만 서브클래스에게 반드시 구현하라고 강요하는 추상 메서드는 있다.
 - 이런 경우 차라리 객체 사용 규칙을 전문적으로 정의하는 인터페이스를 사용하는 게 나음
 
 인터페이스
 모든 필드는 public static final 필드
 모든 메서드는 public, abstract 메서드
 -default 키워드를 이용하여 구현 메서드 만들기 가능
 객체 사용 규칙 정의할때 사용ㅇ하는 문법
 인스턴스를 생성할수 없다.
 */
// 즉 서브 클래스에게 공통 분모를 상속해주기 위한 역할을 한다.
// 이런 클래스의 경우 직접 인스턴스를 만들어 사용하지 않도록 
// 추상 클래스로 선언하는 것이 유지보수에 좋다.
// 특히 추상 메서드를 갖는 경우에는 더더욱 무조건 추상 클래스로 선언해야 한다.


public interface List {
  // 인터페이스의 메서드는 기본적으로 public이고 abstract이다.
  void add(Object item);
  Object[] toArray();
  boolean remove(Object item);


}