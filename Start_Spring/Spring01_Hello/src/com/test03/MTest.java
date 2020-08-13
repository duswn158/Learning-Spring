package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// 기존방식
		// 1.
		// Resource res  = new FileSystemResource("src/com/test03/beans.xml");
		// 2.
		// Resource res  = new ClassPathResource("src/com/test03/beans.xml");
		// BeanFactory factory = new XmlBeanFactory(res);
		
		// 최근방식
		// 3.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		// xml 파일의 경로를 읽어서 ApplicationContext 객체를 만든다 해당 xml의 경로는 "com/test03/beans.xml"
		// 해당 xml 내부에 있는 bean태그들의 경로를 읽어서 객체로 만들어 메모리에 저장한다.
		
		// 어떤 객체가 만들어질지 몰라서 오브젝트로 만들것 따라서 명시적 형변환
		MessageBean english = (MessageBean)factory.getBean("bean01");
		english.sayHello("Spring");
		
		MessageBean korean = (MessageBean)factory.getBean("bean02");
		korean.sayHello("스프링");
		
		/*
		 * BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext
		 * 
		 * 스프링은 ApplicationContext 객체는 스프링 컨테이너 인스턴스 이다
		 * 스프링은 ApplicationContext 인터페이스의 여러 객체를 제공한다.
		 * ClassPathXmlApplicationContext : 지정된 ClassPath 에서 xml파일을 읽어서 bean 생성 
		 */
		
	}

}
