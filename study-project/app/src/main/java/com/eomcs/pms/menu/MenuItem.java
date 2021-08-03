package com.eomcs.pms.menu;

//역할
// - 메뉴 항목을 표현하는 역할을 함
// - 메뉴에 작업 객체를 등록해 놓으면 해당 메뉴를 실행할 때 
//그 객체를 규칙에 따라 실행한다.

// Command 규칙에 따라 리스너 객체를 실행하는 코드를 추가함.

public class MenuItem extends Menu {
  ActionListener [] listeners = new ActionListener[10];
  int size;
  public MenuItem(String title) {
    super(title);
  }
  
  public void addActionListner(ActionListener listener) {
    if (this.size == this.listeners.length) {
      return;
  }
  this.listeners[this.size++] = listener;
  }
  
  @Override
  public void execute() {
    //메뉴를 실행하면 이 메뉴에 등록된 모든 리스너에게 알림
    for (int i = 0; i < this.size; i++) {
      //뱅려에 보관된 각각의 리스너 객체에 대해
      //ActionListener 규칙에 따라 메서드 호출
      //=> 리스너에게 알린다는 의미.
      this.listeners[i].doAction();
    }
  }
}
