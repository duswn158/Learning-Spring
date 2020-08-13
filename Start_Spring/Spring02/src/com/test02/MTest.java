package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address hawn = (Address) factory.getBean("ingu");
		System.out.println(hawn);
		
		Address seng = (Address) factory.getBean("seng");
		System.out.println(seng);
	}

}
