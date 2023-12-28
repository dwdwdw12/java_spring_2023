package com.ezen.polymophism;

import org.springframework.stereotype.Component;

@Component
public class LGTV implements TV{
	
	public LGTV() {
		System.out.println("LG TV 생성자");
	}

	@Override
	public void powerOn() {
		System.out.println("LG TV powerON");
	}

	@Override
	public void powerOff() {
		System.out.println("LG TV powerOFF");
	}

	@Override
	public void volumeUp() {
		System.out.println("LG TV volumeUP");
	}

	@Override
	public void volumeDown() {
		System.out.println("LG TV volumeDOWN");
	}

}
