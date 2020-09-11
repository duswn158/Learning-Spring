package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : " + remoteAddr + "\n")			// client의 ip주소
		  .append("* uri : " + uri + "\n")
		  .append("* url : " + url + "\n")
		  .append("* queryString : " + queryString + "\n")
		  .append("* referer : " + referer + "\n")					// 이전 페이지 (보내는 페이지) url 
		  .append("* agent : " + agent);							// 사용자 정보 (browser, os, ...)
		
		System.out.println("LogFilter");
		System.out.println(sb);

		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
	}

}













