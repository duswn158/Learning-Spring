package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		// 리턴된 객체(즉 부모타입으로 리턴한 자식객체의).dayInfo() 했기 때문에 해당 요일이 나오게됨
		AbstractTest today = (AbstractTest) factory.getBean("singleton");
		System.out.println("오늘 : " + today.dayInfo());	
		
	}
	
}

/*
 	싱글톤 레지스트리
 	- 스프링이 직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공
 	싱글톤과 거의 비슷함 완전 같지는 않음, 싱글톤이긴 함
 	(스프링 빈 오브젝트는 내부적으로 싱글톤 레지스트리를 만들어서 연동)
 	메모리가 절약된다.
 */
