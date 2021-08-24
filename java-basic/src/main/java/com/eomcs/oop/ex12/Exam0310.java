// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0310 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  public static void main(String[] args) {
    // 로컬 클래스
//    class MyPlayer implements Player {
//      @Override
//      public void play() {
//        System.out.println("실행!");
//      }
//    }
//
//    testPlayer(new MyPlayer());
//
//  }
    
    //1번 
//     Player player = new Player() {
//      @Override
//      public void play() {
//        System.out.println("실행!");
//      }
//    };
//    
//    testPlayer(player);
 
      
    
    //2번
//    testPlayer(new Player() {
//      @Override
//      public void play() {
//        System.out.println("실행!");
//      }
//    });
    
   //3번
    
    testPlayer (
        () -> System.out.println("실행")
    );
}
}


