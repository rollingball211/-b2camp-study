package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

public class BoardDetailMenu extends Menu{

  BoardHandler boardHandler;
  public BoardDetailMenu(BoardHandler boardHandler) {
  super("등록");
  this.boardHandler= boardHandler;
}
  
  @Override
public void execute() {
  
  boardHandler.add();
}
}
