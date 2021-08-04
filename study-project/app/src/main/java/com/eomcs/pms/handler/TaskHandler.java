package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public class TaskHandler  {

  static class Node {

    Task task;
    Node next;
    
    public Node(Task task){
      this.task = task;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  //TaskHandler의 여러 메서드에서 지속적으로 사용할 의존 객체를 인스턴스 필드로 받는다
  //다른패키지의 클래스에서 이 변수를 사용할수 있도록 접근 모두는 공개함.
  
  //2.
  //의존 객체는 생성자를 통해 주입받기때문에 외부에서 인스턴스 변수에 직접 접근할 이유는 없다.
  //전체공개모드에서 default로 패키지 멤버에게만 공개하는 모드를 사용함.
  MemberHandler memberHandler;
  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  
  public TaskHandler(MemberHandler memberHandler) {
    this.memberHandler= memberHandler;
  }
  public void add() {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");
    task.status = promptStatus(-1);
    task.owner = promptOwner(null);
    if (task.owner == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }
    //task.tasks =  promptMembers(null);

    Node node = new Node(task);

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
   

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");
    Node node = head;
    do {
      System.out.printf("%d, %s, %s, %s, %s\n",
          node.task.no, 
          node.task.content, 
          node.task.deadline, 
          getStatusLabel(node.task.status), 
          node.task.owner);
    }   while (node != null);{
  }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);
    System.out.printf("상태: %s\n", getStatusLabel(task.status));
    System.out.printf("담당자: %s\n", task.owner);
  }

  public void update() {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));
    int status = promptStatus(task.status);
    String owner = promptOwner(task.owner);
    if (owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
      return;
    }

    task.content = content;
    task.deadline = deadline;
    task.status = status;
    task.owner = owner;

    System.out.println("작업를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[작업 삭제]");
    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }


    Node node = head;
    Node prev = null;

    
    while (node != null) {
      if (node.task == task) {
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
   // 현재 노드가 아니라면,
      prev = node; // 현재 노드의 주소를 prev 변수에 저장하고,
      node = node.next; // node 변수에는 다음 노드의 주소를 저장한다.
    }

    size--;

    System.out.println("게시글을 삭제하였습니다.");
  }
 

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  private String promptOwner(String ownerName) {
    while (true) {
      String owner = Prompt.inputString(String.format(
          "담당자%s?(취소: 빈 문자열) ", 
          ownerName != null ? "(" + ownerName + ")" : ""));
      if (memberHandler.exist(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private int promptStatus(int status) {
    System.out.printf("상태%s?\n", status != -1 ? getStatusLabel(status) : "");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }

  private Task findByNo(int no) {
    Node node = head;
    
    while (node != null) {
      if (node.task.no == no) {
        return node.task;
      }
      node = node.next;
    }
    return null;
  }
  
}

