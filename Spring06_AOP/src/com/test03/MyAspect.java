package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	
	public void before(JoinPoint join) {
		// 실제로 연결될 타겟의 타입
		System.out.println(join.getTarget().getClass());
		// 그 메서드에서 어떤 메서드를 호출했는지.
		System.out.println(join.getSignature().getName());
		System.out.println("출석카드를 찍는다.");
	}
	
	public void after() {
		System.out.println("집에 간다xsz.");
	}
	
}
