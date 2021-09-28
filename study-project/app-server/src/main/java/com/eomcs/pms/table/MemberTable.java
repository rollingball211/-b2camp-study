package com.eomcs.pms.table;

import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.server.Request;
import com.eomcs.server.Response;

//역할
//- 게시글 데이터를 저장하고 조회하는 일을 함
// - 게시글 데이터를 파일에 저장하고 파일로부터 로딩하는 일을 함.
public class MemberTable {

  List<Member> list = new ArrayList<>();

  public void execute(Request request, Response response) throws Exception {

    switch (request.getCommand()) {
      case  "member.insert" :
        insert(request ,response);
        break;
      case "member.list" :
        selectList(request, response);
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {

    Member member = request.getValue(Member.class);
    list.add(member);

    response.setStatus(Response.SUCCESS);

  }

  private void selectList(Request request, Response response) throws Exception{

    response.setValue(Response.SUCCESS);
    response.setValue(list);
  }
}