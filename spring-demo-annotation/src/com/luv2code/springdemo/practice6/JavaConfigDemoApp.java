package com.luv2code.springdemo.practice6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClimbingConfig.class);
		
		// get the bean
		Coach theCoach = context.getBean("climbingCoach", Coach.class);
		
		// print daily workout text
		System.out.println(theCoach.getDailyWorkout());
		
		// print daily fortune text
		System.out.println(theCoach.getDaiyFortune());
		
		// close the context
		context.close();
	}

}
