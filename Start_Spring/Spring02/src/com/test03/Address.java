package com.test03;

public class Address {
	
	private String name;
	private String addr;
	private String phon;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhon() {
		return phon;
	}
	public void setPhon(String phon) {
		this.phon = phon;
	}
	
	@Override
	public String toString() {
		return name + "\t 주소 : "+addr + "\t 전화번호 : "+phon;
	}
	

}
