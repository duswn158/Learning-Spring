package com.test05;

public class Emp {
	
	private String name;
	private int salary;
	
	public Emp() {
	}
	
	public Emp(String name, int salary) {
		this.salary = salary;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return name + "\t월급 : " + salary;
	}

}
