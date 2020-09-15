package com.mvc.upgrade.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	
	/*
	 * getTarget() : 대상 객체
	 * getArgs() : 대상 파라미터들
	 * getSignature() : 대상 메서드 정보
	 */
	
	public void beforeLog(JoinPoint join) {
		// Logger = Log 처리 해주는 객체
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("----------AOP Start----------");
		
		Object[] args = join.getArgs();
		if(args != null) {
			logger.info("method : " + join.getSignature().getName());
			for(int i = 0; i < args.length; i++) {
				logger.info(i + "번째 : " + args[i]);
			}
		}
	}
	
	public void afterLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("----------AOP End----------");
	}
	
	public void afterThrowingLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("----------AOP Error Log----------");
		logger.info("ERROR : " + join.getArgs());
		logger.info("ERROR : " + join.toString());
	}

}
