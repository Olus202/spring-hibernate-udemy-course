package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoMethodsExcludeGettersAndSetters()")
	public void beforAddAccountAdvice(JoinPoint theJoinPoint) {
		
			
		System.out.println("\n ========>>> Executing @Before advice on addAccount(with param)");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				Account account = (Account) tempArg;
				
				System.out.println("Name: " + account.getName());
				System.out.println("Level: " + account.getLevel());
			}
		}
	}
	
}
