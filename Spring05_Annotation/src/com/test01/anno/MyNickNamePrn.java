package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// MyNickNamePrn 을 bean으로 등록할것
// context:component-scan 을 사용하여
// <bean id="myNickNamePrn" class="com.test01.anno.MyNickNamePrn"> 으로 만들어줄것이다.
@Component
public class MyNickNamePrn {
	
	// 위를 생성하고 나면, NickName 타입의 객체 찾아 자동으로 땡겨와서 변수에 넣어줄것
	// ref처럼 참조해서 필드변수에 바로 넣어줄것.
	// autowire = "default"와 비슷하게 동작함 이 속성이 걸려있다 생각해도됨.
	// byType으로 먼저 찾고 byName으로 찾음
	@Autowired
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}
	
	public String toString() {
		return "내 별명은" + nickName + " 입니다.";
	}

}
