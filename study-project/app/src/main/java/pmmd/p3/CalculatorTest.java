package pmmd.p3;

public class CalculatorTest {

  public static void main(String[] args) {
      Calculator c1 = new Calculator();
      Calculator c2 = new Calculator();
      c1.plus(c1,3);
      c1.plus(c1,7);
      
      c2.plus(c2, 5);
      c2.plus(c2, 3);
      
      
      System.out.println(c1.result);
      System.out.println(c2.result);
  }

}
