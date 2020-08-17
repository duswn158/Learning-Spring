package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {

	@Autowired // student에만 Autowired가 들어감
	@Qualifier("lee") // 해당 이름을 가진애들만 특정해서 연결하겠다 (두명은 Annotation 할 수 없음, Autowired는 각 하나만 땡겨올 수 있다)
	// 둘을 하려면 School을 하나 더만들어야함
	private Student student;
	private int grade;
	
	public School() {
		
	}
	public School(Student student, int grade) {
		this.student = student;
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return student + "\t grade : " + grade;
	}
	
}
