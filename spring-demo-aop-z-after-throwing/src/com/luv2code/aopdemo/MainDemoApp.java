package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		Account myAccount = new Account();
		myAccount.setName("somename");
		myAccount.setLevel("ddd");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.goToSleep();
		
		theAccountDAO.setName("name");
		theAccountDAO.getName();
		theAccountDAO.setServiceCode("asd");
		theAccountDAO.getServiceCode();
		
		MembershipDAO theMembershipsDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		theMembershipsDAO.addAccount();
		
		context.close();
	}

}
