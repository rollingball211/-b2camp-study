package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectDetailMenu extends Menu{

  ProjectHandler projectHandler;
  public ProjectDetailMenu(  ProjectHandler projectHandler) {
  super("프로젝트 상세 조회");
  this.projectHandler= projectHandler;
}
  
  @Override
public void execute() {
 projectHandler.detail();
}
}
