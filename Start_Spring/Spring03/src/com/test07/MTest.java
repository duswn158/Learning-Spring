package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		// xml내부의 객체생성을 먼저해주고 container가 생성된다
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		System.out.println("Spring Bean Container 생성!");
		
		TV igtv = (TV)factory.getBean("igtv");
		//TV samsong = (TV)factory.getBean("samsong", SamsongTV.class);
		
		igtv.powerOn();
		//samsong.powerOn();
	}

}
