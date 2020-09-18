package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	// org.slf4j
	Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();
		//URI의 하위개념에 URL,URN이 포함되어 있다.
		String uri = req.getRequestURI(); //통합 자원 식별자
		String url = req.getRequestURL().toString(); // 자원, return 타입이 StringBuffer
		String querString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String userAgent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n "+remoteAddr+"\n");
		sb.append("1. "+uri+"\n");
		sb.append("2. "+url+"\n");
		sb.append("3. "+querString+"\n");
		sb.append("4. "+referer+"\n");
		sb.append("5. "+userAgent+"\n");
		
		logger.info("* LOG Filter");
		logger.info(sb+"");
		logger.info("*****");
		
		chain.doFilter(req, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
