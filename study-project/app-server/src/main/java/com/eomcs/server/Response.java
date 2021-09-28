package com.eomcs.server;

//클라이언트에게 응답
public class Response {

  String status;
  Object value;

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";


  public void setStatus(String status) {
    this.status = status;
  }
  public void setValue(Object value) {
    this.value = value;
  }



}