package com.test01;

import org.aspectj.lang.annotation.After;

public class Person implements Human {
	
	String name;
	String job;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String sayName(String name) {
		/*
		   메인에서 syso를 찍으면
		  
		 */
		System.out.printf("나의이름은 %s 입니다 \n", name);
		return String.format("나의이름은 %s 입니다", name);
	}

	@Override
	public String sayJob(String job) {
		System.out.printf("나의 직업은 %s입니다. \n", job);
		return String.format("나의 직업은 %s입니다.", job);
	}

}
