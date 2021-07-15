package com.eomcs.algorithm.quiz;
//출처: codefights.com
//
//주어진 숫자에 짝수가 몇 개인지 세어라.
//예) 
//1010 => 2
//123 => 1
//
//한 줄에 버그가 있다. 고쳐라!
public class Test {

  public static int divisorsPairs(int[] sequence) {

    int result = 0;

    for (int i = 0; i < sequence.length; i++) {
      for (int j = i+1; j < sequence.length; j++) {
        System.out.printf("%d< --------> %d \n" , sequence[i],sequence[j]);
        if (sequence[i] % sequence[j] == 0 || sequence[j] % sequence[i] == 0) {
          result++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] values = {2, 4, 8};
    System.out.println(divisorsPairs(values));

  }

}
