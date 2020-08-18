package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut
	public void qClass() {}
	
	@Before("execution(public * *(..))")
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	@After("execution(public * *(..))")
	public void after() {
		System.out.println("집에간다");
	}
}
