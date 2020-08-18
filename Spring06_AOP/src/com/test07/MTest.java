package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		// 옛날거라서 타겟 호출하면 안되고 프록시 호출해야함
		MessageBean bean = factory.getBean("proxy", MessageBean.class);
		bean.sayHello();
	}

}
