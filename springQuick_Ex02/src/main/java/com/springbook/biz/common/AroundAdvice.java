package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] 비즈니스 로직 수행 전에 처리할 내용...");
		Object returnObj = pjp.proceed();
//		Object returnObj = null;
		System.out.println("[AFTER] 비즈니스 로직 수행 후에 처리할 내용...");

		return returnObj;
	}

}