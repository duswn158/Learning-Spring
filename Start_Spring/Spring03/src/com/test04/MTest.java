package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Engineer leess = factory.getBean("leess", Engineer.class);
		Developer honggd = (Developer)factory.getBean("honggd");
		
		System.out.println(leess);
		System.out.println(honggd);
		
	}

}

/*
 	MTest는 객체를 사용하고 스프링이 객체를 만든다.
*/