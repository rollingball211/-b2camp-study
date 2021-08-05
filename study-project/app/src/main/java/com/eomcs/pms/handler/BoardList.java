package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList extends ArrayList{
  static final int MAX_LENGTH = 5;
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  
public Board findByNo(int no) {
 for (int i = 0; i< this.size; i++) {
   Board board = (Board) list[i];
   if (board.no == no) {
     return boards[i];
   }
 }
  return null;
}
}



