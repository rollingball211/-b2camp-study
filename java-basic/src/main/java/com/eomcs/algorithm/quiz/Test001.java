package com.eomcs.algorithm.quiz;

// 출처: codefights.com
//
// 주어진 숫자에 짝수가 몇 개인지 세어라.
// 예) 
// 1010 => 2
// 123 => 1
//
//한 줄에 버그가 있다. 고쳐라!
public class Test001 {

  static int maxDiff(int[] values) {
  int result=0;
  for(int i=1; i<values.length; i++) {
  int diff = Math.abs(values[i]-values[i-1]);
  if(diff>result) {
    result = diff;
    }
  }
  
  return result;
  
  }
  
  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{2, 4, 1, 0}));

  }

}
