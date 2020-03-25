package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\nProgram throw some exeption... " + e);
		}
		
		System.out.println("After Throwing App\n");
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		context.close();
	}

}
