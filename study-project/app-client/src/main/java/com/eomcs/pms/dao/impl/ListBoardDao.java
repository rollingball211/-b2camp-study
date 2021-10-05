package com.eomcs.pms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.dao.BoardDao;
import com.eomcs.pms.domain.Board;

//역할 
//-게시글을 데이터를 컬렉션 객체를 이용하여 관리함.

public class ListBoardDao implements BoardDao{

  List<Board> list = new ArrayList<>();

  @Override
  public void insert(Board board) throws Exception {
    list.add(board);
  }

  @Override
  public List<Board> findAll() throws Exception {
    // TODO Auto-generated method stub
    return list;
  }

  @Override
  public Board findByNo(int no) throws Exception {
    for (Board b : list) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  @Override
  public void update(Board board) throws Exception {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == board.getNo()) {
        list.set(i, board);
        return;
      }
    }

  }

  @Override
  public void delete(int no) throws Exception {

    for ( int i =0 ; i < list.size(); i++ ) {
      if (list.get(i).getNo() == no) {
        list.remove(i);
        return;
      }
    }
  }

}
