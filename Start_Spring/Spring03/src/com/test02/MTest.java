package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Emp oh = (Emp) factory.getBean("oh");
		Emp in = (Emp) factory.getBean("ingu", Emp.class);
		
		System.out.println(oh);
		System.out.println(in);
	}

}
