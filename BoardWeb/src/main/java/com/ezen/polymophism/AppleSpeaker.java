package com.ezen.polymophism;

public class AppleSpeaker implements Speaker {
	@Override
	public void volumeUp() {
		System.out.println("Apple Speaker volumeUP");
	}

	@Override
	public void volumeDown() {
		System.out.println("Apple Speaker volumeDOWN");
	}
}
