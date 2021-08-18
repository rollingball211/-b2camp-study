package quiz;

import java.util.Scanner;

public class Solution {
/*
 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 
 이 놀이기구의 원래 이용료는 price원 인데, 
 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 
 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다. 
 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 
 return 하도록 solution 함수를 완성하세요.
단, 금액이 부족하지 않으면 0을 return 하세요.

제한사항
놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수
 */
  
  public long solution(int price, int money, int count) {
    long answer = -1;
    
    
    return answer;
}
  
  public static void main(String[] args) {
    Attraction();
  }

  public static void Attraction() {
    Scanner sc = new Scanner(System.in);
    System.out.println("보유금액 입력");
    int money = Integer.parseInt(sc.nextLine());
    
    System.out.println("어트랙션 금액 입력");
    int price = Integer.parseInt(sc.nextLine());
    
    int count = 1;
    
    System.out.println("이용할 횟수");
    int useCase = Integer.parseInt(sc.nextLine()); //몇번 탈건지
    
    for (int i = 0; i < useCase; i++) {
      money = money - (price * count);
      count ++ ;
      
      
          if (money > 0 ) {
            System.out.println( i+1 + "번째 횟수 " + "남은 돈은 " +Math.abs(money) + "입니다.");
          }
          else if (money == 0) {
            System.out.println("잔액이 0원입니다.");
          }
          else if (money < 0 ) {
            System.out.println("어트랙션 타는데 필요한 비용이 "+ Math.abs(money) + "만큼 부족합니다.");
            
          }
        
    }
    sc.close();
    }
  
  }

