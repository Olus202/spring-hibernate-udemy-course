package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoMethods() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getters() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setters() {}
	
	@Pointcut("forDaoMethods() && (!getters() || setters())")
	public void forDaoMethodsExcludeGettersAndSetters() {}
	
	@Before("forDaoMethodsExcludeGettersAndSetters()")
	public void beforAddAccountAdvice() {
		
		System.out.println("\n ========>>> Executing @Before advice on addAccount(with param)");
	}
	
	@Before("forDaoMethodsExcludeGettersAndSetters()")
	public void performApiAnalytics() {
		
		System.out.println("\n ========>>> Perform API Analitics");
	}

}
