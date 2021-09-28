package com.eomcs.pms;

import java.sql.Date;
import java.util.HashMap;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.request.RequestAgent;
import com.eomcs.util.Prompt;

public class ClientApp {

  static RequestAgent requestAgent;

  public static void main(String[] args) throws Exception {


    System.out.println("[PMS 클라이언트]");


    requestAgent = new RequestAgent("127.0.0.1", 8888);


    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("/board/add")) {
        addBoard();
      } else if (input.equals("/board/detail")) {
        detailBoard();
      } else {
        requestAgent.request(input, null);

        if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
          String result = requestAgent.getObject(String.class);
          System.out.println(">>> " + result);


        } else {
          System.out.println("명령 요청 실패!");
        }
      }

      if (input.equalsIgnoreCase("quit")) {
        break;
      }
    }

    requestAgent.close();

    Prompt.close();
  }

  private static void addBoard() throws Exception {
    Board board = new Board();
    board.setNo(1);
    board.setTitle("제목1");
    board.setContent("내용1");
    board.setRegisteredDate(Date.valueOf("2021-1-1"));

    Member m = new Member();
    m.setNo(100);
    m.setName("aaa");
    m.setEmail("aaa@test.com");

    board.setWriter(m);
    //서버에 요청
    requestAgent.request("/board/add", board);

    //서버가 보낸 결과 확인
    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("게시글 저장 성공!");
    } else {
      System.out.println("게시글 저장 실패!");
    }


  }

  private static void detailBoard() throws Exception {

    HashMap<String,Object> map = new HashMap<>();
    map.put("no", 100);


    requestAgent.request("/board/detail", map);


    //서버가 보낸 결과 확인
    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      Board board = requestAgent.getObject(Board.class);
      System.out.println(board);

    } else {
      System.out.println("게시글 조회 실패!");
    }



  }

}