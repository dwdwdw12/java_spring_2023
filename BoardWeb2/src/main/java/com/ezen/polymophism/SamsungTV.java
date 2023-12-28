package com.ezen.polymophism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")	//bean에 등록
public class SamsungTV implements TV {
	
	@Autowired						//주입하는 역할
	@Qualifier("apple")				//찾아주는 역할
	private Speaker speaker;			
	
	private int price;
	
	//setter 생성
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public SamsungTV() {
		System.out.println("SamsungTV 생성자");
	}
	
	public SamsungTV(Speaker speaker) {		
		this.speaker = speaker;
		System.out.println("SamsungTV 생성자");
	}

	public SamsungTV(Speaker speaker, int price) {		
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV 생성자, price = " + price);
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerON, price = " + price);
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOFF");
	}

	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV volumeUP");
		//speaker = new SonySpeaker();	//자바-객체를 생성해 재정의된 메서드 사용
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV volumeDOWN");
		//speaker = new SonySpeaker();
		speaker.volumeDown();
	}

}
