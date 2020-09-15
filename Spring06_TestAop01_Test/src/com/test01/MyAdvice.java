package com.test01;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {
	
	public void beforeSaying() {
		System.out.println("당신의 이름은 무엇입니까?");
	}
	
	public void afterSaying() {
		System.out.println("이름이 멋지시네요");
	}
	
	public void afterReturnSaying(JoinPoint join) {
		System.out.println("직업이 무엇입니까?");
	}

}
