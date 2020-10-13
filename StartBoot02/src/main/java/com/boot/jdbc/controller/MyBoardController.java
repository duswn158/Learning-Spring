package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {
	
	@Autowired
	private MyBiz myBiz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		System.out.println("엥에ㅔ엥에에ㅔ");
		model.addAttribute("list", myBiz.selectList());
		return "bootlist";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, int myno) {
		
		MyDto dto = myBiz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "bootdetail";
	}
	
	@GetMapping("/insert")
	public String insert() {
		
		return "bootinsert";
	}
	
	@GetMapping("/insertres")
	public String insertres(MyDto dto) {
		
		int res = myBiz.insert(dto);
		
		if(res > 0) {
			return "redirect:list";
		} else {
			return "reditect:insert";
		}
			
	}
	
	@GetMapping("/update")
	public String update(Model model, int myno) {
		
		model.addAttribute("dto",myBiz.selectOne(myno));
		
		return "bootupdate";
	}
	
	@GetMapping("/updateres")
	public String updateres(MyDto dto) {
		
		int res = myBiz.update(dto);
		
		if(res > 0) {
			return "redirect:detail?myno="+dto.getMyno();
		} else {
			return "redirect:update?myno="+dto.getMyno();
		}
		
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		
		int res = myBiz.delete(myno);
		
		if (res>0) {
			return "redirect:list";
		} else {
			return "redirect:detail?myno="+myno;
		}
			
		
	}
	

}
