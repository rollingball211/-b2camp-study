package pmmd.p4;

public class CalculatorTest {

  public static void main(String[] args) {
      Calculator c1 = new Calculator();
      Calculator c2 = new Calculator();
      c1.plus(3);
      c1.plus(7);
      c2.plus(5);
      c2.plus(7);
      
      System.out.println(c1.result);
      System.out.println(c2.result);
  }

}
