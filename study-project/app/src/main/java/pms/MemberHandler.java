package pms;

import java.sql.Date;

public class MemberHandler {
  
  //한 회원의 데이터를 저장할 수 있도록
  // 새 구조의 데이터 타입을 정의함.
 static class Member {

    int no;
    String name;
    String email;
    String password;
    String photo;
    String tel;
    Date registeredDate;
    int size;
  }
  static final int MAX_LENGTH = 3;
  
  //Member 인스턴스의 주소를 저장할 레퍼런스를 100개 저장.
  static Member[] members = new Member[MAX_LENGTH];
  static int size =0;
  
    static void add() {
    System.out.println("[회원 등록]");
    
    Member member = new Member();
    
    
    
    //새 회원 정보를 담을 변수를 준비한다.
    // 낱 개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.

   member.no = Prompt.inputInt("번호? ");
    
   member.name= Prompt.inputString("이름? ");

   member.email= Prompt.inputString("이메일? ");

   member.password = Prompt.inputString("암호? ");

    member.photo = Prompt.inputString("사진? ");

   member.tel = Prompt.inputString("전화? ");

   member.registeredDate = new Date(System.currentTimeMillis());
   
   members[size++] = member;
   
 
     
   }
   
    
  

  static void list() {
    System.out.println("[회원 목록]");
    for( int i =0; i<size; i++) {
      System.out.printf("%d,%s,%s,%s,%s\n",
          members[i].no,
          members[i].name,
          members[i].email,
          members[i].password,
          members[i].photo,
          members[i].tel
      
          );
    
    
    }
    }
  }

