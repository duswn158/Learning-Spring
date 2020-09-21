package com.mvc.upgrade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardBiz boardBiz;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("[list.두]");
		
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
	public String update(Model model, int myno) {
		
		model.addAttribute("dto", boardBiz.selectOne(myno));
		
		return "mvcupdate";
		
	}
	
	// (value="/updateres.do", method=RequestMethod.POST) <- 풀세팅(전부 다 설정할거 작성)시 저렇게됨
	@RequestMapping("/updateres.do")
	public String updateres(BoardDto dto) {
		
		int res = boardBiz.update(dto);
		
		if(res > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		} else {
			return "redirect:update.do?myno=" + dto.getMyno();
		}
		
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno){
		
		int res = boardBiz.delete(myno);
		if(res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:detail.do?myno=" + myno;
		}
		
	}
	
	@RequestMapping("/test.do")
	public String transactionTest() {
		
		logger.info("[test.do]");
		
		boardBiz.transactionTest();
		
		return "redirect:list.do";
	}

}
