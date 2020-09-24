package com.mvc.updown.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	
	private String name;
	private String desc;
	private MultipartFile mpfile;
	
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public MultipartFile getMpfile() {
		return mpfile;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setMpfile(MultipartFile mpfile) {
		this.mpfile = mpfile;
	}
		
}
