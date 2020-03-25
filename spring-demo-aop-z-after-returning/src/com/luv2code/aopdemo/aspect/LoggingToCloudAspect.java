package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingToCloudAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoMethodsExcludeGettersAndSetters()")
	public void loggingToCloud() {
		
		System.out.println("\n ========>>> Logging to Cloud");
	}

}
