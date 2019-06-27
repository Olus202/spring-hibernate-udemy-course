package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load a spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve a bean from container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method for fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
