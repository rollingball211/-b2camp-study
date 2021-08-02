package com.eomcs.pms.menu;
//menuitem 과 menuGroup을 같은 타입으로 묶이 위해 정의한 클래스
//인스턴스를 만들어 사용하기 위함이 아니라
//이 클래스 자체는 상속해주는 용도이기 때문에 
//추상 클래스로 정의함.
public abstract class Menu {
  
  String title;
  //메뉴 이름없이 인스턴스를 생성할 수 없도록
  //기본 생성자를 정의하지 않음
  //대신 인스턴스를 만들때 반드시 메뉴 이름을 입력하도록 강요하기 위해 
  //다음과 같이 String을 파라미터로 받는 생성자 생성
  
  Menu(String title){
    title = this.title;
  }
  //서브클래스에서 해야 할 일을 정의함
  //서브클래스에서 재정의할 메소드이기때문에 
  //구체적 구현 x 
  public abstract void execute();
}
