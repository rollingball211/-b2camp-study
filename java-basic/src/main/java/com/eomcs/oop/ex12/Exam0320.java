// 아규먼트에 람다(lambda) 활용 II - 파라미터와 리턴 값이 있는 람다 만들기
package com.eomcs.oop.ex12;

public class Exam0320 {

  static interface Calculator {
    int compute(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.compute(100, 200));
  }

  public static void main(String[] args) {
    //1번
    
//    class cal implements Calculator {
//
//      @Override
//      public int compute(int a, int b) {
//        // TODO Auto-generated method stub
//        return a+b;
//      }
//      
//    }
//    cal obj = new cal();
    
//    test(obj);

    
   //2번
    
//    Calculator obj = new Calculator() {
//
//      @Override
//      public int compute(int a, int b) {
//        // TODO Auto-generated method stub
//        return a+b;
//      }
//      
//    };
//    
//    test(obj);

    //3번
    
//    test(new Calculator() {
//
//      @Override
//      public int compute(int a, int b) {
//        // TODO Auto-generated method stub
//        return a+b;
//      }
//      
//    });
    
    //4-1번 
    
    //test((int a, int b ) ->  (return a+b ));
    
    
    //4-2번 
    
    test((a,b) -> a + b );
    // 람다 
    // 파라미터와 리턴 값이 있는 메서드 구현하기
    test((a, b) -> a + b);

  }

}


