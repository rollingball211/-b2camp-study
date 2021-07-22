package pmmd.p3;

public class Calculator {

  int result;

  
   void plus(Calculator c, int value) {
    c.result += value;
  }
  void minus(Calculator c,int value) {
    c.result -= value;
  }
  void multiple(Calculator c,int value) {
    c.result *= value;
  }
  
   void divide(Calculator c,int value) {
    c.result /= value;
  }


}
