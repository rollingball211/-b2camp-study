package com.eomcs.pms.menu;

public class MenuGroup extends Menu{

  Menu[] childs = new Menu[100];
  int size;
  
  //생성자를 정의하지않으면 컴파일러가 기본 생성자를 자동으로 추가함
  //컴파일러가 추가한 기본 생성자는 수퍼 클래스의 기본 생성자를 호출하기 떄문에
  //컴파일 오류가 발생함. 
  //Menu 클래스에서는 기본 생성자가 없음.
  
  public MenuGroup(String title) {
    super(title);
  }
  
  //MenuGroup이 포함하는 하위 Menu를 다룰 수 있도록 메서드 정의.
  public void add(Menu childMenu) {
    if(this.size == this.childs.length) {
      return; //하위 메뉴를 저장할 배열이 꽉 찼다면 더이상 저장x
    }
    this.childs[this.size++] = childMenu;
    
  }
  
  public void remove(Menu child) {
    int index = indexOf(child);
    for(int i = index+1 ; i<this.size; i++) {
      this.childs[i-1] = this.childs[i];
    }
    this.childs[--this.size] = null;
  }
  
  public int indexOf(Menu child) {
    for(int i = 0; i<this.size; i++) {
      if ( childs[i] == child) {
        return i;
      }
    }
    return -1;
  }
  
  public Menu getMenu(String title) {
    return null;
  }
  @Override
  public void execute() {
    
  }
  
  
  
}
