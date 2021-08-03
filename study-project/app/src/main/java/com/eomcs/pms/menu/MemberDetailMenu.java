package com.eomcs.pms.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberDetailMenu extends Menu{

  MemberHandler memberHandler;
  public MemberDetailMenu(MemberHandler memberHandler) {
  super("회원 상세조회");
  this.memberHandler= memberHandler;
}
  
  @Override
public void execute() {
  
 memberHandler.detail();
}
}
