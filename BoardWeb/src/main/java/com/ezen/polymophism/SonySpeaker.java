package com.ezen.polymophism;

public class SonySpeaker implements Speaker{

	@Override
	public void volumeUp() {
		System.out.println("Sony Speaker volumeUP");
	}

	@Override
	public void volumeDown() {
		System.out.println("Sony Speaker volumeDOWN");
	}
	
}
