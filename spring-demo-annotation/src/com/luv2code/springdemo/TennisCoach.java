package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> inside the default constructor");
	}
	
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> inside the setter method");
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand vollay";
	}

	@Override
	public String getDaiyFortune() {
		return fortuneService.getFortune();
	}

}
