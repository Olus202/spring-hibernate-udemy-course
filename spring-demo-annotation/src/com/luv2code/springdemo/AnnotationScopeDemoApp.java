package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach theSecondCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == theSecondCoach);
		
		System.out.println(result);

	}

}
