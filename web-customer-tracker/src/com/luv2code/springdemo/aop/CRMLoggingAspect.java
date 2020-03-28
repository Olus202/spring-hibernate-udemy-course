package com.luv2code.springdemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forControllerServiceAndDaoPackages() {
	}

	@Before("forControllerServiceAndDaoPackages()")
	public void before(JoinPoint theJoinPoint) {

		String method = theJoinPoint.getSignature().toShortString();

		myLogger.info("\n ========>>> @Before advice on: " + method);

		Object[] args = theJoinPoint.getArgs();

		for (Object arg : args) {
			myLogger.info(arg.toString());
		}
	}

	@AfterReturning(pointcut = "forControllerServiceAndDaoPackages()", returning = "theResult")
	public void after(JoinPoint theJoinPoint, Object theResult) {

		String method = theJoinPoint.getSignature().toShortString();

		myLogger.info("\n ========>>> @Before advice on: " + method);

		myLogger.info(theResult.toString());

	}

}
