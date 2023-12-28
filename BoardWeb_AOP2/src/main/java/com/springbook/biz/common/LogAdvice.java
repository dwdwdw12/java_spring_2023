package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")	//execution까지 입력해주기
	public void allPointCut() {}
	
	@Before("allPointCut()")		//괄호까지 붙여줘야 함
	public void printLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 로그] 비즈니스 로직 수행 전 동작 >> " + methodName);
		System.out.println("Argument 정보 >> " + args[0].toString());
	}
}
