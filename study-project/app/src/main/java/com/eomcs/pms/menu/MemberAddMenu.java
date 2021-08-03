package com.eomcs.pms.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberAddMenu extends Menu{

  MemberHandler memberHandler;
  public MemberAddMenu(MemberHandler memberHandler) {
  super("회원 등록");
  this.memberHandler= memberHandler;
}
  
  @Override
public void execute() {
  
 memberHandler.add();
}
}
