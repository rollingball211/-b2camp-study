package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {
  static class Node {

    Project project;
    Node next;
    
    public Node(Project project){
      this.project = project;
    }
  }

  Node head;
  Node tail;

  
  //projectHandler가 받을 의존 객체
  //다음과 같이 인스턴스 필드로 받음
  //이 인스턴스 변수에 의존객체의 주소를 넣을 수 있도록 공개한다
  MemberHandler memberHandler;
  int size = 0;
  
  
  //생성자 선언
  //인스턴스를 생성할 때 반드시 호출되는 메서드.
  //리턴 타입 x
  //-메서드 이름이 클래스 이름과 같아야함
  //인스턴스 변수를 유효한 값으로 초기화시킨다.
  //- 필요하다면 인스턴스 변수를 초기화시킬 때 사용할 값을 파라미터로 받을 수 있다.
  
   public ProjectHandler(MemberHandler memberHandler) {
    //생성나에 파라미터가 있으면 인스턴스를 생성할 때 반드시 그 값을 넘겨야 함.
    //일종의 인스턴스 변수의 값을 설정하는것을 강제하는 효과가 있음.
    this.memberHandler = memberHandler;
  }
  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

   project.owner = promptOwner(null);
   if (project.owner == null) {
     System.out.println("프로젝트 등록을 취소합니다.");
     return;
   }
    //project.members =  promptMembers(null);

    Node node = new Node(project);

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
    System.out.println("[프로젝트 목록]");
    Node node = head;
do {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          node.project.no,
          node.project.title, 
          node.project.startDate, 
          node.project.endDate, 
          node.project.owner,
          node.project.members);
        } while (node != null);{
  }
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);
    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.title);
    System.out.printf("내용: %s\n", project.content);
    System.out.printf("시작일: %s\n", project.startDate);
    System.out.printf("종료일: %s\n", project.endDate);
    System.out.printf("만든이: %s\n", project.owner);
    System.out.printf("팀원: %s\n", project.members);
  }

  public void update() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.startDate));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));

    String owner = promptOwner(project.owner);
    if  (owner == null) {
      System.out.println("프로젝트 변경 취소");
      return;
    }

    String members = promptMembers(project.members);


    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.title = title;
    project.content = content;
    project.startDate = startDate;
    project.endDate = endDate;
    project.owner = owner;
    project.members = members;

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");
     Project project = findByNo(no);
    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    Node node = head;
    Node prev = null;

    
    while (node != null) {
      if (node.project == project) {
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
 
  


  private Project findByNo(int no) {
 Node node = head;
    
    while (node != null) {
      if (node.project.no == no) {
        return node.project;
      }
      node = node.next;
    }
    return null;
  }
  
  
  
 
  private String promptOwner(String ownerName) {
   
    while (true) {
      //회원 이름이 등록된 회원의 이름인지 검사할 때 사용할 MemberHandler 인스턴스는
      //인스턴스 변수에 미리 주입되어 있기 떄문에 파라미터로 받을 필요가 없다.
      //다음과 같이 인스턴스 변수를 사용하면 됨.
      String label = String.format("만든이%s(취소:빈 문자열)",
          ownerName != null ? "(" + ownerName + ")" : "");
      String owner = Prompt.inputString(label);
      if (memberHandler.exist(owner)) {
        return owner;
        
      } else if (owner.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return null; // 메서드 실행을 즉시 종료!
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }
  
  private String promptMembers(String members) {
    String newMembers = "";
    while (true) {
      String member = Prompt.inputString(String.format(
          "팀원?(완료: 빈 문자열) ",
          members != null ? "(" + members + ")" : ""));
      if (memberHandler.exist(member)) {
        if (members.length() > 0) {
          members += ",";
        }
        members += member;
        continue;
      } else if (member.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return newMembers;
  }
}
