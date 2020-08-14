package com.test07;

public class SamsongTV implements TV {
	
	public SamsongTV() {
		System.out.println("SamsongTV 생성!!");
	}

	@Override
	public void powerOn() {
		System.out.println("Samsong powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("Samsong powerOff");
	}

	@Override
	public void volumeUp() {
		System.out.println("Samsong voluemUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("Samsong volumeDown");
	}

}
