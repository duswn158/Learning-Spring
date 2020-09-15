package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz memberBiz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("[loginform.do]");
		return "mvclogin";
	}
	
	
	/*
	 * 둘은 정반대
	 * 
	 * @RequestBody : request 객체에 담겨져서 넘어오는 데이터를 -> java 객체에 "binding" 해줌(연결, 묶어준다)
	 * json 형태로 만들어서 값 전달 해준것들이 이것과 묶여질것
	 * 즉 아래에서는 ajax로 넘어온 json 문자열을 Dto타입으로 바꿔서 MemberDto와 연결해줌, 넣어줌
	 * json으로 request된 애들 MemberDto dto랑 binding해줘서 dto에값을 넣어준다
	 * 
	 * @ResponseBody : java 객체를 -> response 객체의 데이터로 "binding" 정확히는 json으로 바꿔줌
	 * 즉 아래에서 map으로 담은걸 jackson이 json형태로 바꿔줌, Response객체에 담아서 json으로 리턴해줌 (String도 되는데 그냥 왠만하면 json으로 쓰자)
	 * client(mvclogin.jsp) 즉 ajax(서버몰래 비동기) 요청하면서 json으로 받기때문에 Jackson이 바꿔줌
	 * 원래 모델앤드 뷰로 리턴하는데 ajax이기 때문에 그냥 바로 자바객체를 Response시킴
	 * 응답객체 Body에 return해주는것을 (아래에선 map) 즉 map을 추가시켜줌 따라서 ViewResolver을 거치지 않고 바로 응답함
	 */
	
	
	@RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody
	// 로그인 결과 담을 세션 (서버가 클라이언트를 관리할때 사용하는 객체, 브라우저 하나당 세션 하나)
	public Map<String, Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		
		logger.info("[ajaxlogin.do]");
		
		MemberDto res = memberBiz.login(dto);
		
		// id 와 pw 가 제대로 있다면 즉 제대로 로그인 되었다면
		boolean check = false;
		if(res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		// ajax로 비동기 통신 요청중. 뷰 리졸브 통하지 않고 다시 클라이언트로 가고픔
		return map;
	}
	
}
