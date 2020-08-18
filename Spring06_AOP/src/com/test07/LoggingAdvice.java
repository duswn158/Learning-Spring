package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

// MethodInterceptor 를 상속받는다!
public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName = invocation.getMethod().getName();
		
		// Spring에 있는 StopWatch
		StopWatch timer = new StopWatch();
		timer.start(methodName);
		
		System.out.println("[LOG] Method : " + methodName + " is Calling");
		
		Object obj = invocation.proceed();
		timer.stop();
		
		System.out.println("[LOG] Method : " + methodName + " was Called");
		System.out.println("[LOG] Time : " + timer.getTotalTimeSeconds() + " sec");
		
		return obj;
	}

}
