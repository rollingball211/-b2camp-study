package com.eomcs.lang.ex04;

public class Exam0951 {

  
   //# 형변환 = 명시적 형변환이 불가능한 경우 ,특벼랗ㄴ 메서드를 사용하면 가능.
  public static void main(String[] args) {

    // 1) 정수 메모리끼리 형변환이 가능하다.
    // 2) 부동소수점을 정수로 형변환이 가능한다.
    // 3) 형변환 없이 정수는 부동소수점 메모리에 저장할 수 있다.
    // 4) 숫자를 문자 코드로 형변환 가능한다.
    // 그 외에는 형변환 불가!

    // 예) 정수, 부동소수점 ==/==> boolean
    boolean bool;
    //bool = (boolean) 1; // 컴파일 오류!
    
    // 예) 문자열 ==/==> 정수, 부동소수점, 문자, boolean
    //boolean v1 = (boolean) "true"; // 컴파일 오류!
    //char v2 = (char) "가"; // 컴파일 오류!
    //int v3 = (int) "123"; // 컴파일 오류!
    //float v4 = (int) "3.14f"; // 컴파일 오류!
    
    boolean v1 = Boolean.valueOf("true");
    char v2  = "가".charAt(0);
    int v3 = Integer.valueOf("123");
    int v33 =Integer.parseInt("123");
    
    float v4 = Float.valueOf("3.14f");
    float v44 =Float.valueOf(v4);
 
    
  }
}
