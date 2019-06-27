package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoClass {

	public static void main(String[] args) {
		
		// add context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get Coach bean
		ClimbingCoach myCoach = context.getBean("myClimbingCoach", ClimbingCoach.class); 
		
		ClimbingCoach mySecondCoach = context.getBean("myClimbingCoach", ClimbingCoach.class);
		
		boolean result = (myCoach == mySecondCoach);
		
		System.out.println("Result: " + result);
		
		// close context
		context.close();

	}

}
