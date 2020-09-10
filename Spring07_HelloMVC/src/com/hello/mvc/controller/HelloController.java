package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.biz.HelloBiz;

@Controller
public class HelloController {

	// TODO : 05. biz(@Service) 호출
	@Autowired
	private HelloBiz biz;
	
	// TODO : 04. handler mapping("/hello.do") 통해 controller의 메서드를 찾아온다.
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		// TODO : 09. return받은 값을 model 객체에 담아서 전달 (ModelAndView)
		model.addAttribute("message", biz.getHello());
		
		// view name (String을 리턴해주면 모델객체를 이용해서 hello.jsp에 모델의 값을 넣어서 hello-servlet 즉 dispathcher servlet에 넘겨줌
		return "/WEB-INF/views/hello.jsp";
	}
	
	// 변수설정하는 이름과 넘어올때의 파라미터값이 같다면 @RequestParam() 생략 가능
	// 즉, (@RequestParam("name") String name) 상태라면 생략 가능
	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name") String nickname) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "Bye, " + nickname);
		
		return mav;
	}
	
}

/*
 
 @RequestMapping
 - url을 class 또는 method와 mapping 시켜주는 역할
 
 @RequestParam
 - view에서 넘어오는 파라미터를 controller 안에서 연결해줌
 - key = value 로 넘어오는 queryString(Parameter) 을 mapping된 method의 파라미터와 연결시켜줌
 - get방식 하나하나 연결할때 사용
 
 @ModelAttribute
 - form tag를 통해 넘어온 model을 mapping된 method의 파라미터와 연결
 - post방식에서 주로 사용 (get방식도 가능)
 
 @SessionAttribute
 - session 객체에 model 정보를 유지하고 싶을 경우 사용 즉, session에 model값 저장할때 사용
 
 */
