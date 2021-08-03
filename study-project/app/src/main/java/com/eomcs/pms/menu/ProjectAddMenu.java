package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectAddMenu extends Menu{

  ProjectHandler projectHandler;
  public ProjectAddMenu(  ProjectHandler projectHandler) {
  super("프로젝트 등록");
  this.projectHandler= projectHandler;
}
  
  @Override
public void execute() {
 projectHandler.update();
}
}
