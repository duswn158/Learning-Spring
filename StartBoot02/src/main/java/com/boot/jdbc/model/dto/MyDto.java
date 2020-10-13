package com.boot.jdbc.model.dto;

import java.util.Date;

public class MyDto {
	
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
	
	public MyDto() {
	}
		
	
	public MyDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}
	public int getMyno() {
		return myno;
	}
	public String getMyname() {
		return myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public Date getMydate() {
		return mydate;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	

}
