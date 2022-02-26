package com.song.web.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component //스프링컨테이너에 빈(모듈) 등록하는 어노테이션
//@Aspec
public class LogAdvice {
		@Pointcut("execution( * com.song.web..*ServiceImpl.*(..)	)")
		public void allpointcut()	{}
		//어노테이션에 포인트컷 불러오기!
		@Before("allpointcut()")
		public void logBefore(JoinPoint jp) {
			log.info("[before]=============");
			String methodName = jp.getSignature().getName();
			Object[] arg=jp.getArgs(); //배열로 받아주기
			String str= methodName + ":arg=" + ( arg!=null && arg.length>0? arg[0] : "");
			log.info(str);
		}
		@AfterReturning(pointcut = "allpointcut()", returning = "obj")
		public void logAfter(JoinPoint jp,Object obj) {
			log.info("[after]=============");
			String methodName= jp.getSignature().getName();
			String string = methodName + ":return=" + (obj != null? obj : "");
			log.info(string);
		}
}
