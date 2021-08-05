package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList {
  static final int MAX_LENGTH = 5;
  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;
  MemberHandler memberHandler;
  
  public void add(Project project) {
    if (size == projects.length) {
    Project [] arr  = new Project[projects.length + (projects.length/2)];
    for (int i = 0; i < size; i++) {
      arr[i] = projects[i];
    }
      projects = arr;
    }
    this.projects[this.size++] = project;
  }
  
  
  public Project[] toArray() {
    Project [] arr = new Project[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만듬.
    for (int i = 0; i<this.size ; i++) { // 배열에 저장된 값을 새 배열에 복사함.
      arr[i] = projects[i];
    }
    return arr; //새 배열 리턴.
  }
  
  public Project findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        return this.projects[i];
      }
    }
    return null;
  }
  
  public Boolean remove(Project project) {
    int index = indexOf(project);
    
    if( index == -1) {
      return false;
    }
    
    for (int i = index + 1; i < this.size; i++) {
      this.projects[i - 1] = this.projects[i];
    }
    this.projects[--this.size] = null;
    return true;
  }
  
  
  private int indexOf(Project project) {
    for (int i = 0; i < this.size; i++) {
      if (this.projects[i] == project) {
        return i;
      }
    }
    return -1;
  }
  
 



}



