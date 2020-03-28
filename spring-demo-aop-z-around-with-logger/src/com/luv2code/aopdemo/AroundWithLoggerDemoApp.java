package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nAround Main App... ");
		
		myLogger.info("Running getFortune()");
		
		boolean boolParam = true;
		Object result = trafficFortuneService.getFortune(boolParam);
		
		myLogger.info(result.toString());
		myLogger.info("End of the method\n");
		
		context.close();
	}

}
