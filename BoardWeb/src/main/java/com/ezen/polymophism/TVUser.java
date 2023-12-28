package com.ezen.polymophism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	
	public static void main(String[] args) {
		
//		TV tv = new SamsungTV();	//resources>applicationContext.xml 작성 이전
//		
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
		
		//1.스프링 컨테이너 구동									//resources>applicationContext.xml 작성 이후
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");	//해당 어플리케이션 파일을 읽어옴
																				//samsungtv 객체를 생성해 올림
		//2. 스프링 컨테이너에서 필요한 빈을 요청
		TV tv = (TV) factory.getBean("tv");	//반환타입이 object이므로 tv로 캐스팅. getBean("application xml에서 지정한 id값")
//		TV tv = factory.getBean("tv2", LGTV.class);	//형 변환 대신 사용가능-자바 리플리케이션
		
		tv.volumeUp();				//메모리 상에는 SamsungTV, LG TV 객체가 각각 생성되어 있음.
		tv.volumeDown();
		
//		factory.close(); 			//사용 후에는 닫아주기. 없으면 destroy-method 동작하지 않음
		
		//applicationContext.xml 참고
		//init-method="initMethod" : 객체 생성시 동작
		//destroy-method="destoryMethod" : 객체 소멸시 동작
		//lazy-init = "true" : 객체 생성x. 필요한 시점에 만들어줌(21번 문장)  
		
		TV tv1 = (TV) factory.getBean("tv");
		TV tv2 = (TV) factory.getBean("tv");
		
		System.out.println(tv1);		//com.ezen.polymophism.SamsungTV@4a7f959b
		System.out.println(tv2);		//com.ezen.polymophism.SamsungTV@4a7f959b //두 객체가 같음. 기본적으로 싱글톤 패턴.
		
		//scope="prototype" 추가할 경우, 요청시마다 객체를 새로 생성함. 기본은 scope="singleton"
		
		factory.close(); 
	}
	
}
