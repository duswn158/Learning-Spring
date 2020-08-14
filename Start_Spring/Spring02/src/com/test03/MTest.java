package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Address lee = (Address)factory.getBean("lee");
		System.out.println(lee);
		
		Address hong = (Address)factory.getBean("hong");
		System.out.println(hong);
		
		// 메모리 누수방지
		// ApplicationContext을 상속받은
		// ClassPathXmlApplicationContext 에는 close가 오버라이드 되어있기 때문에 사용함
		// 부모타입으로 만들어 두었기 때문에 다시 자식타입으로 바꾸어 사용
		((ClassPathXmlApplicationContext)factory).close();
	}

}
