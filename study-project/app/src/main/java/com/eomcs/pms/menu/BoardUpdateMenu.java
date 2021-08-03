package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

public class BoardUpdateMenu extends Menu{

  BoardHandler boardHandler;
  public BoardUpdateMenu(BoardHandler boardHandler) {
  super("수정");
  this.boardHandler= boardHandler;
}
  
  @Override
public void execute() {
  
  boardHandler.update();
}
}