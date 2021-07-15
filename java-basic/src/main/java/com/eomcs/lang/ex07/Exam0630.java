package com.eomcs.lang.ex07;

// # JVM 아규먼트 응용 II
//
public class Exam0630 {

  public static void main(String[] 변수명은상관없다) {
    // JVM에 기본으로 설정되어 있는 프로퍼티를 모두 출력하라!
    //
    // JVM의 전체 프로퍼티 목록 가져오기
    
    //1)properties 객체에 저장되어있는 값의 이름(key)를 알아낸다.
    java.util.Properties props = System.getProperties();

    java.util.Set keySet = props.keySet();

    
    //이름 목록에서 한 개의 이름을 가져와서 그 이름으로 저장된 값을 꺼낸다.
    //이름 목록에서 꺼낸 값이 실제는 String 이지만,
    // 문법 상에서는 Object로 되어있어서
    // 변수를 선언할 때 Object 타입으로 변수를 선언해야 함.
    for (Object key : keySet) {
      String value = props.getProperty((String) key);
      System.out.printf("%s======>%s \n" , key ,value);
    }
    
  //getProperty()에 이름을 전달할 때는 String을 전달해야함
    //key에 들어있는것은 String이나 문법상으론 object
    // getproperty에 key 변수에 들어 있는 값ㅇ르 전달 할 때
    //string 이라고 컴파일러에게 알려줘야 함.
//    for (Object key : keySet) {
//      
//      String value = System.getProperty((String) key);
//      System.out.printf("%s = %s\n", key, value);
//    }
  }
}


