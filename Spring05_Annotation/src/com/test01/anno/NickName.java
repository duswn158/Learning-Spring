package com.test01.anno;

import org.springframework.stereotype.Component;

// NickName이란 이름으로 Bean으로 등록이 되게할것.
// 즉 context:component-scan 을 사용하여
// 아래를 <bean id="nickName" class="com.test01.anno.NickName" /> 으로 만들어준다
// 자동으로 만드는데. 첫글자는 소문자로 바꾼 클래스이름과 동일하게 만들어줄것.
@Component
public class NickName {
	
	public String toString() {
		return "teacher";
	}

}
