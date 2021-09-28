package com.eomcs.pms.handler;

import java.io.IOException;
import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.request.RequestAgent;
import com.eomcs.util.Prompt;

public class BoardAddHandler implements Command{

  RequestAgent requestAgent;

  public BoardAddHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void execute(CommandRequest request) throws IOException{
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));

    //   board.setWriter(AuthLoginHandler.getLoginUser());
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    requestAgent.request("board.insert", board);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("게시물을 등록했습니다.");
    }else {
      System.out.println("게시물 등록을 실패했습니다.");
    }
  }
}







