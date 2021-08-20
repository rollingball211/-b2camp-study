package com.eomcs.pms.handler;

//추상클래스에 최정적인 타입 이름은
//서브 클래스를 정의할 떄 전달함
public abstract class AbstractList<E> implements List<E> {
  protected int size;

  @Override
  public int size() {
    return this.size;
  }
}
