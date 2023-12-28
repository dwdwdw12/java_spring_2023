package com.ezen.polymophism;

public class SamsungTV implements TV {
	
	private Speaker speaker;			//추가
	private int price;
	
	//setter 생성
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("initMethod 생성자 => 초기화 문장 기입");
	}
	
	public void destoryMethod() {
		System.out.println("객체 소멸시 구동");
	}
	
	public SamsungTV() {
		System.out.println("SamsungTV 생성자");
	}
	
	public SamsungTV(Speaker speaker) {		//추가
		this.speaker = speaker;
		System.out.println("SamsungTV 생성자");
	}

	public SamsungTV(Speaker speaker, int price) {		//추가
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
