package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		// 경로 com/test03/applicationContext.xml 확장자까지
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Emp ingu = (Engineer)factory.getBean("ingu");
		System.out.println(ingu);
		
		Emp oh = (Developer)factory.getBean("oh");
		System.out.println(oh);
		
	}

}
