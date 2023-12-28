package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect
public class LogAdvice {
	
//	@Before("execution(* org.zerock.service.SampleService*.*(..))")	//SampleService로 시작하는 클래스의 모든 메서드 대상
//	@After("execution(* org.zerock.service.SampleService*.*(..))")	
//	@AfterReturning("execution(* org.zerock.service.SampleService*.*(..))")	
//	@AfterThrowing("execution(* org.zerock.service.SampleService*.*(..))")	//에러 발생시 동작. 미발생시 생략
	public void logBefore() {
//		System.out.println("before===================");
//		System.out.println("After===================");
//		System.out.println("AfterReturning===================");
		System.out.println("AfterThrowing===================");
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")	
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();		//초-1000밀리초-1000*1000마이크로초-1000*1000*1000나노초
		log.info("Target >> " + pjp.getTarget());
		log.info("Param >> " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		
		log.info("time >> " + (end-start));
		
		return result;
	}
	
}
