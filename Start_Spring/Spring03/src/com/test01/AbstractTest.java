package com.test01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {
	
	public abstract String dayInfo();
	
	// 타입이 나 자신 즉 나를 만들어 나 자신을 리턴한다 (싱글톤)
	public static AbstractTest getInstance() {
		
		GregorianCalendar cal = new GregorianCalendar();
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
		// Abstract 클래스를 상속받은 자식객체들
		// 자식객체를 부모타입으로 리턴함 (다형성에 의해 자식객체가 부모타입으로 자동 형변환 되었음)
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wendesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		
		return null;
	}

}
