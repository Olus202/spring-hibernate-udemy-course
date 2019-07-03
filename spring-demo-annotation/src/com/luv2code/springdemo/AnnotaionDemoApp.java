package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotaionDemoApp {

	public static void main(String[] args) {
		
		// read the context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
//		Coach theClimbingCoach = context.getBean("climbingCoach", Coach.class);
		
		// print daily workout text
		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(theClimbingCoach.getDailyWorkout());
		
		// print daily fortune text
		System.out.println(theCoach.getDaiyFortune());
		
		// close the context
		context.close();
	}

}
