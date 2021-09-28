package com.eomcs.server;

//클라이언트에게 응답
public class Response {

  String status;
  Object value;

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  public static String getSuccess() {
    return SUCCESS;
  }
  public static String getFail() {
    return FAIL;
  }






}