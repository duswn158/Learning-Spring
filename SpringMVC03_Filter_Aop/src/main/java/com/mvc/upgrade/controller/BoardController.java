package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardBiz boardBiz;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("list", boardBiz.selectList());
		
		return "mvclist";
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		
		BoardDto dto = boardBiz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "mvcdetail";
	}
	
	@RequestMapping("/insert.do")
	public String insert(Model model) {
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) {
		int res = boardBiz.insert(dto);
		
		if(res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:insert.do";
		}
	}
	
	@RequestMapping("/update.do")
	public String updateForm(Model model, int myno) {

		model.addAttribute("dto", boardBiz.selectOne(myno));

		return "mvcupdate";
	}

	@RequestMapping("/updateres.do")
	public String updateRes(BoardDto dto) {

		int res = boardBiz.update(dto);
		if (res > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		} else {
			return "redirect:update.do?myno=" + dto.getMyno();
		}
	}

	@RequestMapping("/delete.do")
	public String delete(int myno) {

		int res = boardBiz.delete(myno);
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:detail.do?myno=" + myno;
		}
	}

}





