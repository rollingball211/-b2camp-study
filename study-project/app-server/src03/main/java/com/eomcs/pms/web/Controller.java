package com.eomcs.pms.web;

import java.lang.annotation.Retention;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Retention(Retention.policy)
public interface Controller {
  String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
