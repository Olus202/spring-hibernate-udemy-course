package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proccJointPoint) throws Throwable {
		
		String method = proccJointPoint.getSignature().toShortString();
		
		myLogger.info("\n ========>>> Executing @Around advice on " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = proccJointPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			
//			result = "Major problem - but it is solved!"; // handle exception
			throw e;
		}
		
		long end = System.currentTimeMillis();
		long duration = end - begin;
		
		myLogger.info("\n ========>>> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
		
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n ========>>> Executing @After advice on " + method);
		
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n ========>>> Executing @AfterThrowing advice on " + method);
		
		myLogger.info("\n ========>>> Exception " + theExc);
		
	}
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n ========>>> Executing @AfterReturning advice on " + method);
		
		myLogger.info("\n ========>>> Result" + result);
		
		convertToUpperCaseName(result);
		myLogger.info("\n ========>>> Result" + result);
	}
	
	private void convertToUpperCaseName(List<Account> result) {
		for (Account acc : result) {
			String upperName = acc.getName().toUpperCase();
			acc.setName(upperName);
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoMethodsExcludeGettersAndSetters()")
	public void beforAddAccountAdvice(JoinPoint theJoinPoint) {
		
			
		myLogger.info("\n ========>>> Executing @Before advice on addAccount(with param)");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				
				Account account = (Account) tempArg;
				
				myLogger.info("Name: " + account.getName());
				myLogger.info("Level: " + account.getLevel());
			}
		}
	}
	
}
