package ex05;

public class Hello {

static int countEvenNumber(int value) {
  int n = value;
  int count =0;
  while(n>0){
     if( n % 2== 0){
          count++;
  }
    n /=10;
  }
 
  return count;
}
 
public static void main(String[] args) {
  System.out.println(countEvenNumber(1238694636));
}
}
