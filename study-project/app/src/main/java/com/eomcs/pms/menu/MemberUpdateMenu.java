package com.eomcs.pms.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberUpdateMenu extends Menu{

  MemberHandler memberHandler;
  public MemberUpdateMenu(MemberHandler memberHandler) {
  super("회원 수정");
  this.memberHandler= memberHandler;
}
  
  @Override
public void execute() {
  
 memberHandler.update();
}
}
