package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] >> 비즈니스 메소드 실행 전");

		String methodName = pjp.getSignature().getName();	//메서드 이름 기록
		
		StopWatch stopWatch = new StopWatch();		//시간 기록
		
		stopWatch.start();
		Object returnObj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(methodName + "메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		System.out.println("[BEFORE] >> 비즈니스 메소드 실행 후");
		
		return returnObj;
	}
	
}
