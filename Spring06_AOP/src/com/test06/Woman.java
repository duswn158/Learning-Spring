package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person {

	@Override
	public void classWork() {
		System.out.println("컴켜서 쇼핑한다");
	}

}
