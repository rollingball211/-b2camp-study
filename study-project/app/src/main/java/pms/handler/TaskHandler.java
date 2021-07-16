package pms.handler;

import com.eomcs.util.Prompt;
import pms.domain.TaskMember;

public class TaskHandler {
  static final int TASK_LENGTH = 100;

  static int tSize = 0;
  static TaskMember[] taskMemberArray = new TaskMember[TASK_LENGTH];


  public static void addTask() {
    System.out.println("[작업 등록]");
    
    TaskMember taskmember= new TaskMember();
    
    taskmember.tNo = Prompt.inputInt("번호? ");
    taskmember.tContent = Prompt.inputString("내용?: ");

    taskmember.tDeadline = Prompt.inputDate("마감일: ");

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    taskmember.tStatus = Prompt.inputInt("> ");

    taskmember.tOwner = Prompt.inputString("담당자? ");

   //for(tSize = 0; tSize<TASK_LENGTH; tSize++) {
    // taskMemberArray[tSize] = taskmember;
    // }
 
   taskMemberArray[tSize++] =taskmember;
  }

  public static void listTasks() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < tSize; i++) {
      String stateLabel = null;
      switch (taskMemberArray[i].tStatus) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }
      // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          taskMemberArray[i].tNo, 
          taskMemberArray[i].tContent,
          taskMemberArray[i].tDeadline,
           stateLabel,
          taskMemberArray[i].tOwner);
    }
  }
}
