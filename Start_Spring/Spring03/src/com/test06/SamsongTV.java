package com.test06;

public class SamsongTV implements TV {

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
