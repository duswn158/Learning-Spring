package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 디스패처 서블릿에서 컨트롤러로 넘어갈때 동작
		logger.info("[LoginInterceptor] preHandle");
		
		// Spring 3.2 이상 부터는 servlet-context.xml 에서 <exculude-mapping-path> 태그를 통해 설정할 수 있다.
		// 해당 조건일때만 디스패처서블릿(컨트롤러)으로 넘어갈 수 있도록 조건을 건다.
		if(request.getRequestURI().contains("/loginform.do") || // loginform.do로 요청되고 있거나
				request.getRequestURI().contains("/ajaxlogin.do") || // ajaxlogin.do로 요청되고 있거나
				request.getSession().getAttribute("login") != null || //이미 로그인이 되어있을때
				request.getRequestURI().contains("/test.do")) 
		{
			return true; // 컨트롤러로 넘겨주지 않을것
		}
		
		// 아래 구문 없을시 return false이기 때문에 그냥 하얀화면 나온다
		// 로그인이 안되어있다면 (로그인 세션에 값이 없다면)
		if(request.getSession().getAttribute("login") == null) {
			// loginform.do 로 넘겨버린다
			response.sendRedirect("loginform.do");
			return false;
		}

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// 컨트롤러가 디스패처서블릿한테 리턴할때 동작
		logger.info("[LoginInterceptor] postHandle");
		// logger.info(modelAndView.getViewName()); java.lang.NullPointerException 뜸
		
		// 즉 비동기가 아니라 정상적으로 값 가져와서 응답시킬때만 아래 구문을 찍어라
		if(modelAndView != null) {

			// 뷰 이름 출력할것.
			// request response 할때 가져오는 명령어인데
			// 리스폰스 바디 어노테이션으로 ajax를 연결해서 비동기, 자바객체로 가져왔기 때문에
			// null값이다! 에러나니까 if문 써줌
			logger.info(modelAndView.getViewName());
			
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Callback after completion of request processing, that is, after rendering the view.
		// view 화면이 만들어 진 후에 동작한다
		logger.info("[LoginInterceptor] afterCompletion");
	}

}
