package com.test01;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanTest {
	
	private MyClass myClass;
	
	public BeanTest() {
		System.out.println("기본 생성자!!!");
	}
	
	public BeanTest(Date date) {
		System.out.println("Date 받는 생성자 : " + date);
	}
	public BeanTest(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("MyClass 받는 생성자");
	}
	
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("etMyFlass 호출");
	}
	
	public void setDate(Date date) {
		System.out.println("setDate(Date date)호출! " +date);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber(int num) 호출 : " + num);
	}
	
	public void setArray(String[] arr) {
		System.out.println("SetArray(STring[] arr) 호출");
		for(String s : arr) {
			System.out.println(s);
		}
	}
	
	public void setList(List<String> list) {
		// 자동으로 String 타입으로 가져올것
		System.out.println("setList(List<String> list) 호출");
		System.out.println(list);
	}
	
	public void setSet(Set<String> set) {
		
		System.out.println("setSet(Set<String> set)");
		for (String s : set) {
			System.out.println(s);
		}
		
	}
	
	public void setMap(Map<String, String> map) {
		
		System.out.println("setMap(Map<String, String> map) 호출");
		/*
		 * Collection<String> values = map.values(); for(String value : values) {
		 * System.out.println(value); }
		 */
		
		// key = value 출력 (Entry)
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore(List<Score> list) 호출");
		for (Score sc : list){
			System.out.println(sc);
		}
	}

}
