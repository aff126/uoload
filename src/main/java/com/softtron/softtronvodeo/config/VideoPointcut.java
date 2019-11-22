package com.softtron.softtronvodeo.config;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class VideoPointcut {
	@Pointcut("execution(* com.softtron.softtronvodeo.service.*.*(..))")
	public void uploadpointcut() {
		
	}
	@Around("execution(* com.softtron.softtronvodeo.service.*.*(..))")
	public void beforeSyso(ProceedingJoinPoint joinpoint) throws Throwable {
		try {
			System.out.println("before");
			joinpoint.proceed();
		} catch (Throwable e) {
			System.out.println("111");
			throw e;
		}
	}
}
