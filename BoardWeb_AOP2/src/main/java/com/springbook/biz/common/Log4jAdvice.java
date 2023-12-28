package com.springbook.biz.common;

import org.springframework.stereotype.Service;

@Service
public class Log4jAdvice {
	
	public void printLogging(){
		System.out.println("[공통로그 log4j] 비즈니스 로직 수행 전 동작");
	}

}
