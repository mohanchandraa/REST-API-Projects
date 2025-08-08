package com.user.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect //telling spring that we are writing extra logic
@Component //Spring takes care of this class like object creation
@Slf4j
public class LoggingAspect {
	
//	@Before("execution(* com.user.controller.UserController.addUser(..))")
//	public void logBeforeAddUser() {
//		log.warn("Logging something before addNewUser endpoint");
//	}
	
	@Before("execution(* com.user.controller.UserController.addUser(..))")
	public void logBeforeAddUser(JoinPoint joinPoint) {
		log.error("Logging something before addNewUser endpoint");
		log.warn("which method we are calling"+joinPoint.getSignature().getName());
		log.error("Logging before AddUser");
	}
}
