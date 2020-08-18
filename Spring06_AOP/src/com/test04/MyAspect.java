package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("출석카드를 찍는다.");
	}
	@After("execution(public String *(..))")
	public void after(JoinPoint join) {
		System.out.println("집간다");
	}
	// 메서드 내부에 뭔가 문제가 생겼을때 출력된다
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는날이었다");
	}
	// 리턴되는 값은 classwork메서드에서 주는것
	@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
	// 타겟에서 리턴하는 값을 받아 사용할수있게 해줌
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + "공부하는 날이었다");
	}

}
