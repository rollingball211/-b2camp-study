package com.eomcs.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Log4j
//프로그램을 실행하는 중에 특정 변수의 값이나 상태, 오류 내용을
//콘솔이나 파일에 기록하고 싶을 때 사용하는 라이브러리이다.
//단계별로 출력을 제어할수잇다.
//프로그램 실행 과정을 추적하거나 디버깅할때 유용함.

//사용법
// 1)log4j 라이브러리 파일을 프로젝트에 포함
// -search.maven.org 사이트에서 log4j로 검색
// 라이브러리 정보를 build.gradle에 포함시킴
// $gradle eclipse를 실행하여 라이브러리를 가져오고 , 이클립스 설정파일 갱신.

public class Exam01 {


  //기록을 남길 때 사용할 도구 준비
  //-클래스 당 한개의 도구만 있어도 된닫.
  private static final Logger logger = LogManager.getLogger(Exam01.class);
  public static void main(String[] args) {

    System.out.println("고전맨");
    logger.fatal("{},{},{}" , "FATAL","aaa",100);
    logger.error("ERROR!");
    logger.warn("내용=>WARN");
    logger.info("내용=>INFO");
    logger.debug("내용=>DEBUG");
    logger.trace("내용=>trace");
  }


  /* 
   로그 레벨 중요도 
   trace < debug <info < warn < error < fatal

   1) trace
    -실행 과정을 순서대로 자세하게 확인하고 싶을 때 사용한다.
   2) debug
    -개발자 입장에서 변수의 값을 확인하고 싶을 때 사용한다.
   3) info
   - 주요 메서드의 호출이나 실행 흐름을 확인하고 싶을 떄 사용한다.
   4) warn
    - 시스템 실행에는 문제가 없으나 형예외가 발생할수 있는 상황을 기록하고 싶을 떄 사용한다.
   5) error
   - 실행 중 발생한 오류를 기록하고 싶을 때 사용한다.
   6) fatal
   - 복구가 불가능한 , 즉 시스템을 즉시 종료해야하는 상황을 기록할 때 사용한다. 

  출력 레벨 설정
   -출력 레벨을 지정하면 그 레벨 이상의 모든 레벨에 대해 출력을 허락한다.



   */
}
