package com.eomcs.pms.menu;

import com.eomcs.pms.handler.TaskHandler;

public class TaskUpdateMenu extends Menu{

  TaskHandler taskHandler;
  public TaskUpdateMenu(TaskHandler taskHandler) {
  super("작업 수정");
  this.taskHandler= taskHandler;
}
  
  @Override
public void execute() {
  taskHandler.update();
}
}
