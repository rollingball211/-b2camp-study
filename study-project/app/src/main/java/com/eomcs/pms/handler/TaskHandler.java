package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public class TaskHandler  {

  static final int MAX_LENGTH = 5;

  Task[] tasks = new Task[MAX_LENGTH];
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
    if (this.size == this.tasks.length) {
      // 기존 배열 보다 50% 더 큰 배열을 만든다.
      Task[] arr = new Task[this.tasks.length + this.tasks.length / 2];

      // 기존 배열의 값을 새 배열로 복사한다.
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.tasks[i];
      }

      //기존 배열 대신 새 배열 주소를 저장한다.
      // => 물론 이렇게 함으로써 기존 배열은 가비지가 될 것이다.
      this.tasks = arr;
    }
    this.tasks[this.size++] = task;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          this.tasks[i].no, 
          this.tasks[i].content, 
          this.tasks[i].deadline, 
          getStatusLabel(this.tasks[i].status), 
          this.tasks[i].owner);
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

    int index = indexOf(no);
    if (index == -1) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.tasks[i - 1] = this.tasks[i];
    }
    this.tasks[--this.size] = null;

    System.out.println("작업를 삭제하였습니다.");
  }

  private Task findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        return this.tasks[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        return i;
      }
    }
    return -1;
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

}

