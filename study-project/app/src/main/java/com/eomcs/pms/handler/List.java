package com.eomcs.pms.handler;


//인터페이스에 제네릭(generic)의 타입 파라미터를 적용하면
// 그 타입의 최종적인 이름ㅇ느 이 인터페이스를 구현하는 클래스에서 결정.
public interface List<E> {
  void add(E item);
  Object[] toArray();
  boolean remove(E obj);
  int size();
  E get(int index);
  E remove(int index);
}









