package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class ArrayList {
  static final int MAX_LENGTH = 5;
  Object list [] = new Object[MAX_LENGTH];
  int size = 0;
  
  public void add(Object obj) {  
    if (size == list.length) {
      Object[] arr = new Board[list.length + (list.length / 2)];
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr; //board 확장
    }
  this.list[this.size++] = obj;
  }

  public Object[] toArray() {
    Object [] arr = new Object[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만듬.
    for (int i = 0; i<this.size ; i++) { // 배열에 저장된 값을 새 배열에 복사함.
      arr[i] = list[i];
    }
    return arr; //새 배열 리턴.
  }
  
  public Boolean remove(Object obj) {
    int index = indexOf(obj);
    if( index == -1) {
      return false;
    }
    
    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;
    return true;
  }

  
  private int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i]== obj) {
        return i;
      }
    }
    return -1;
  }
  }

