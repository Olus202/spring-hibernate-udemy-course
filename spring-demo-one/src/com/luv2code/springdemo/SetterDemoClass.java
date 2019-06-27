package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoClass {

	public static void main(String[] args) {
		
		// add context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get Coach bean
		CricketCoach myCoach = context.getBean("myCricketCoach", CricketCoach.class); 
		
		// run method for daily
		System.out.println(myCoach.getDailyWorkout());
		
		// run method for fortune
		System.out.println(myCoach.getDailyFortune());
		
		// get literal value from email
		System.out.println(myCoach.getEmailAddress());
		
		// get literal value from team
		System.out.println(myCoach.getTeam());
		
		// close context
		context.close();

	}

}
