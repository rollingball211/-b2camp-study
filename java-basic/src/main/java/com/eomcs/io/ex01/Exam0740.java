// 활용 - 클래스 파일 이름을 출력할 때 패키지 이름을 포함하라. (람다 문법 활용)
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0740 {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir, "");
  }

  static void printClasses(File dir, String packageName) {

    File[] files = dir.listFiles(f -> 
    f.isDirectory()|| (f.isFile() && f.getName().endsWith(".class")));
    if (packageName.length() > 0) {
      packageName += ".";
    }
    for (File f : files) {
      if (f.isDirectory()) {
        printClasses(f,packageName +  f.getName());
      } else {
        System.out.println(packageName +   f.getName());
      }
    }
  }
}


