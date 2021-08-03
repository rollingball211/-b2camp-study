package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectUpdateMenu extends Menu{

  ProjectHandler projectHandler;
  public ProjectUpdateMenu(  ProjectHandler projectHandler) {
  super("프로젝트 수정");
  this.projectHandler= projectHandler;
}
  
  @Override
public void execute() {
 projectHandler.update();
}
}
