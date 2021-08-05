package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;
public class MemberList2 {
  static class Node {
    Member member;
    Node next;

    public Node(Member member) {
      this.member = member;
    }
  }
  
  Node head;
  Node tail;
  int size = 0;

public void add(Member member) {  
  Node node = new Node(member);

  if (head == null) {
    tail = head = node;
  } else {
    // 기존에 tail이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장한다.
    tail.next = node;

    // 새로 만든 노드를 마지막 노드로 설정한다. 
    tail = node;
  }

  size++;
}

public Member[] toArray() {
  //배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만듬.
  Member [] arr = new Member[this.size];
  Node node = head;

  int i = 0;
  while (node != null){
    arr[i++] = node.member;
    node = node.next;
  }
  return arr;
}

public Member findByNo(int no) {
 
  Node node = head;
  while (node != null) {
    if (node.member.no == no) {
      return node.member;
    }
    node = node.next;
  }
  return null;
}

public Boolean remove(Member member) {
  Node node = head;
  Node prev = null;

  while (node != null) {
    if (node.member == member) { //노드에 들어있는 객체와 같다면
      if (node == head) { //삭제할 노드가 첫번째 노드라면.
        head = node.next;//head가 두번째 노드를 가르키게 한다.
      } else {
        prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
      }

      node.next = null; // 삭제할 노드가 더이상 다음 노드를 카리키지 않게 함.

      if (node == tail) { // 삭제할 현재 노드가 마지막 노드라면
        tail = prev; // 이전 노드를 마지막 노드로 설정한다.
      }
      size--;
     return true;
    }

    // 현재 노드가 아니라면,
    prev = node; // 현재 노드의 주소를 prev 변수에 저장하고,
    node = node.next; // node 변수에는 다음 노드의 주소를 저장한다.
  }

  
  return false;
}
}




