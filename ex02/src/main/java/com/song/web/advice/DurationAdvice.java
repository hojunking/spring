package com.song.web.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
//@Aspect
public class DurationAdvice {

	
	@Around("LogAdvice.allpointcut()") //서비스 전 후 둘다 출력한다.
	public Object logTime(ProceedingJoinPoint pjp)  {
		long start = System.currentTimeMillis();
		Object obj = null;
		
		
		try {//서비스 메서드 호출합니다.
			obj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		long end = System.currentTimeMillis();
		log.info("time====" +(end - start));
		return obj;
		
	}
	// allpointcut() 들고 올 수 있습니다.
	
	
}
