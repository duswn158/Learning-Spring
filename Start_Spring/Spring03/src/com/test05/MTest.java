package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		Engineer leess = (Engineer)factory.getBean("leess");
		Developer honggd = factory.getBean("honggd", Developer.class);
		
		System.out.println(leess);
		System.out.println(honggd);
		
	}

}
