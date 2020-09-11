package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private BoardBiz boardBiz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		System.out.println("[list.do]");
		
		model.addAttribute("list", boardBiz.selectList());
		
		return "mvclist";
	}
	
	@RequestMapping("/insert.do")
	public String insertForm() {
		System.out.println("[insert.do]");
		
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto, Model model) {
		System.out.println("[insertres.do]");
		
		int res = boardBiz.insert(dto);
		if (res > 0) {
			model.addAttribute("list", boardBiz.selectList());
			return "mvclist";
		}
		
		return "mvcinsert";
	}
	
	@RequestMapping(value="/detail.do")
	public String detail(Model model, @RequestParam("myno") int myno) {
		System.out.println("[detail.do]");
		
		BoardDto dto = boardBiz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "mvcdetail";
	}
	
	@RequestMapping(value="/delete.do")
	public String delete(int myno) {
		System.out.println("[delete.do]");
		
		int res = boardBiz.delete(myno);
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:detail.do?myno="+myno;
		}
	}
	
	@RequestMapping(value="/update.do")
	public String updateForm(Model model, int myno) {
		System.out.println("[update.do]");
		
		BoardDto dto = boardBiz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "mvcupdate";
	}

	@RequestMapping(value="/updateres.do", method=RequestMethod.POST)
	public String updateRes(BoardDto dto) {
		System.out.println("[updateres.do]");
		
		int res = boardBiz.update(dto);
		if (res > 0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		}
		
		return "redirect:update.do?myno="+dto.getMyno();
	}
	
}




















