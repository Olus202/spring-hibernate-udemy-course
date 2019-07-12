package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
//		Coach theClimbingCoach = context.getBean("climbingCoach", Coach.class);
		
		// print daily workout text
		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(theClimbingCoach.getDailyWorkout());
		
		// print daily fortune text
		System.out.println(theCoach.getDaiyFortune());
//		System.out.println(theClimbingCoach.getDaiyFortune());
		
		// print the email and the team
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
