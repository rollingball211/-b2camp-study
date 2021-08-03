package com.eomcs.pms.menu;

//게시글 등록 메뉴를 선택했을 때 작업을 수행할 객체를 정의함
//단 ActionListener 규칙에 따라 메서드 정의
//그래야만 MenuItem에 이 객체 등록 가능
//MenuItem도 이 규칙에 따라 호출 가능.
public class BoardDetailListener implements ActionListener {

  @Override
  public void doAction() {
    System.out.println("===========>게시글 상세조회!!!!");
  }
}
