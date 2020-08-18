package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	// qClass() 메서드를 통해 포인트컷을 사용할수 있게 해준다
	@Before("qClass()")
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	
	@After("qClass()")
	public void after() {
		System.out.println("집에간다");
	}
	
	@Pointcut("execution(public * *(..))")
	public void qClass() {
		
	}
	
}
