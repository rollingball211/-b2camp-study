package pms01b;

public class SwitchTest {

  public static void main(String[] args) {
    int [] switchValue = new int[4];
    switchValue[0] = 1;
    switchValue[1] = 2;
    switchValue[2] = 3;
    switchValue[3] = 4;
    for(int i =0; i<switchValue.length; i++) {
      switch(switchValue[i]) {
        
        case 1: System.out.println("숫자 1");
                break;
        case 2: System.out.println("숫자 2");
                break;
        case 3: System.out.println("숫자 3");
                break;
        default : System.out.println("123이 아닌 숫자 ");
      }
      
    }
  }

}
