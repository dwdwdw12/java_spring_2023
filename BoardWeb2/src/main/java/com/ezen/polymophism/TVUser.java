package com.ezen.polymophism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	
	public static void main(String[] args) {
		
		//1.스프링 컨테이너 구동									//resources>applicationContext.xml 작성 이후
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");	//해당 어플리케이션 파일을 읽어옴
																				//samsungtv 객체를 생성해 올림
		//2. 스프링 컨테이너에서 필요한 빈을 요청
		TV tv = (TV) factory.getBean("samsung");	
		
		tv.powerOn();
		tv.volumeUp();				
		tv.volumeDown();
	
		
		factory.close(); 
	}
	
}
