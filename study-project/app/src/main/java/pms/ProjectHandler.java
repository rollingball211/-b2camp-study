package pms;

import java.sql.Date;

public class ProjectHandler {
  static final int PROJECT_LENGTH = 1000;
  static int pSize = 0;
  
  static class Pmember{
    int pNo;
    String pTitle;
    String pContent;
    Date pStartDate;
    Date pEndDate;
    String pOwner;
    String pMembers;
    
  }
 static Pmember[] pmemberArray = new Pmember[PROJECT_LENGTH];
 
  
 
  
  static void addProject() {
    
    Pmember pmember = new Pmember();
    System.out.println("[프로젝트 등록]");

   pmember.pNo = Prompt.inputInt("번호? ");

   pmember.pTitle = Prompt.inputString("프로젝트명? ");

   pmember.pContent = Prompt.inputString("프로젝트 내용: ");

   pmember.pStartDate = Prompt.inputDate("시작일");

   pmember.pEndDate = Prompt.inputDate("종료일");

   pmember.pOwner = Prompt.inputString("만든이?: ");

   pmember.pMembers= Prompt.inputString("팀원?: ");

    pmemberArray[pSize++]=pmember;
  }

  static void listProjects() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < pSize; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          pmemberArray[i].pNo,
          pmemberArray[i].pTitle,
          pmemberArray[i].pStartDate,
          pmemberArray[i].pEndDate, 
          pmemberArray[i].pOwner);
    }
  }
}
