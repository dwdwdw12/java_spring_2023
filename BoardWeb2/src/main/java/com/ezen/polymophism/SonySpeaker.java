package com.ezen.polymophism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("Sony Speaker 생성자");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("Sony Speaker volumeUP");
	}

	@Override
	public void volumeDown() {
		System.out.println("Sony Speaker volumeDOWN");
	}
	
}
