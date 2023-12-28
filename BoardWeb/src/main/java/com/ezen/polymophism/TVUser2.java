package com.ezen.polymophism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser2 {
	
	public static void main(String[] args) {
				
		//1.스프링 컨테이너 구동									//resources>applicationContext.xml 작성 이후
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");	//해당 어플리케이션 파일을 읽어옴
																				//samsungtv 객체를 생성해 올림
		//2. 스프링 컨테이너에서 필요한 빈을 요청
		TV tv = (TV) factory.getBean("tv");	//반환타입이 object이므로 tv로 캐스팅. getBean("application xml에서 지정한 id값")
		
		tv.powerOn();
		tv.volumeUp();				//Sony Speaker volumeUP		//생성자를 주입한 경우(전제조건: 생성자가 존재하며, sony-speaker를 받을 수 있어야 함.)
		tv.volumeDown();			//Sony Speaker volumeDOWN	//생성자를 만든 경우
		
		factory.close(); 
	}
	
}
