package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {

  // 모든 게시판의 최대 배열 개수가 같기 때문에 다음 변수는 
  // 그냥 static 필드로 남겨둔다.
  static final int MAX_LENGTH = 5;

  // 게시판 마다 따로 관리해야 하기 때문에 인스턴스 필드로 전환한다.
  // => static 옵션을 뺀다.
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  // BoardHandler 설계도에 따라 만든 변수(boards, size)를 다룰 수 있도록 
  // 파라미터로 인스턴스 주소를 받는다.
  // 
  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    //    board.viewCount = 0; // 인스턴스 변수는 생성되는 순간 기본 값이 0으로 설정된다.

    this.boards[this.size++] = board;
  }

  // BoardHandler 설계도에 따라 만든 변수(boards, size)를 다룰 수 있도록 
  // 파라미터로 인스턴스 주소를 받는다.
  // 
  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].writer,
          this.boards[i].registeredDate,
          this.boards[i].viewCount, 
          this.boards[i].like);
    }
  }
  
  public void detail() {
  System.out.println("상세 조회");
  int no = Prompt.inputInt("번호?");
  
  Board board = null;
  
  for(int i =0; i<this.size; i++) {
    if(boards[i].no == no) {
      board = boards[i];
      break;
  }
  }
  if (board == null) {
    System.out.println("해당 번호의 게시글이 없습니다.");
    return;
  }
  System.out.printf("제목 : %s \n ", board.title);
  System.out.printf("내용 : %s \n ", board.content);
  System.out.printf("작성자: %s \n " , board.writer);
  System.out.printf("등록일: %s \n ", board.registeredDate);
  System.out.printf("조회수: %s \n ", ++board.viewCount);
  
}
  
  public void update() {
    System.out.println("[개시글 변경]");
    int no = Prompt.inputInt("번호?");
    Board board = null;

    for(int i =0; i<this.size; i++) {
      if(boards[i].no == no) {
        board = boards[i];
        break;
      }
    }
    
   if(board == null) {
     System.out.println("해당 번호의 게시글이 없습니다.");
     return;
   }
   
   board.title = Prompt.inputString("제목을 어떻게 바꾸시겠습니까? ");
   board.content = Prompt.inputString("내용을 어떻게 바꾸시겠습니까?");
   System.out.println("정말 변경하시겠습니까?? Y|N");
   String input = Prompt.inputString("> ");
   if(input.equalsIgnoreCase("Y")) {
     board.title = boards[no-1].title;
     board.content = boards[no-1].content;
     System.out.println("게시글 변경 완료!");
     
   }else if(input.equalsIgnoreCase("N") || input.length() == 0) {
   System.out.println("변경을 취소했습니다!!");
     return;
   }
  }
  

  public void delete() {
    System.out.println("[개시글 삭제]");
    int no = Prompt.inputInt("번호?");
    Board board = null;

    for(int i =0; i<this.size; i++) {
      if(boards[i].no == no) {
        board = boards[i];
        break;
      }
    }
    
   if(board == null) {
     System.out.println("해당 번호의 게시글이 없습니다.");
     return;
   }
   
  
   System.out.println("정말 변경하시겠습니까?? Y|N");
   String input = Prompt.inputString("> ");
   if(input.equalsIgnoreCase("Y")) {
//     board.no = 0;
//     board.title = null;
//     board.content = null;
//     board.registeredDate=null;
//     board.writer = null;
//     board.like=0;
//     board.viewCount=0;
     for(int i = 0; i<MAX_LENGTH; i++) {
      // 07/21
     }
     
     
     
     System.out.println("게시글 변경 완료!");
     
   }else if(input.equalsIgnoreCase("N") || input.length() == 0) {
   System.out.println("변경을 취소했습니다!!");
     return;
   }
  }
  }










