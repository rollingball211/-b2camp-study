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
  
  Node head;
  Node tail;

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    // 새 노드를 만든다. 생성자를 호출할 때, 노드에 담을 Board 객체 주소를 넘긴다. 
    Node node = new Node(board);

    if (head == null) {
      tail = head = node;
    } else {
      // 기존에 tail이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장한다.
      tail.next = node;

      // 새로 만든 노드를 마지막 노드로 설정한다. 
      tail = node;
    }

    size++;
  }

  public void list() {
    System.out.println("[게시글 목록]");
    if (head == null) {
      return;
    }

    Node node = head;

    do {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          node.board.no, 
          node.board.title, 
          node.board.writer,
          node.board.registeredDate,
          node.board.viewCount, 
          node.board.like);
      node = node.next;
    } while (node != null);
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

   

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");
    Board board = findByNo(no);
    Node node = head;

    // Board 인스턴스가 들어 있는 배열을 뒤져서
    // 게시글 번호와 일치하는 Board 인스턴스를 찾는다. 
    

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }
    
   
    
    
    Node prev = null;
    
    while (node != null) {
      if (node.board == board) {
        if (node == head) {
          head = node.next;
        }else {
          prev.next = node.next; //이전 노드와 다음 노드와 연결함
        }
        node.next = null; //다음 노드와의 연결을 끊음
        
        if(tail == node) {  //삭제할 현재 노드가 마지막 노드라면.
          tail = prev; //이전 노드를 마지막 노드로 설정함.
          
        }
        break;
      }
    }
  }
    
    
//    if (head == null) {
//     System.out.println("삭제할 수 없습니다.");
//     return;
//    } else{
//      // 삭제할 node를 null로 바꾼다.
//      if(board.no == no) {
//      tail.board = null;
//      if(tail == node) {
//        return;
//      }
//      tail.next= node;
//      }
//      size--;
//      System.out.println("게시글을 삭제하였습니다.");
//      // 새로 만든 노드를 마지막 노드로 설정한다.
//      //만약 마지막 노드를 삭제했다면  뒤로 넘기지 않고 끝
//  
//  }
  


  private Board findByNo(int no) {
    Node node = head;
    
    while (node != null) {
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    }
    return null;
  }
}






