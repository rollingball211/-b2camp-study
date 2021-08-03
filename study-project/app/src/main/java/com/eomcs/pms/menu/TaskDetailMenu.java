package com.eomcs.pms.menu;

import com.eomcs.pms.handler.TaskHandler;

public class TaskDetailMenu extends Menu{

  TaskHandler taskHandler;
  public TaskDetailMenu(TaskHandler taskHandler) {
  super("작업 상세조회");
  this.taskHandler= taskHandler;
}
  
  @Override
public void execute() {
  taskHandler.detail();
}
}
