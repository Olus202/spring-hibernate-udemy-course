package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClimbingCoach implements Coach {

	@Autowired
	@Qualifier("climbingFortuneService")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Let's try to do this 7a+";
	}

	@Override
	public String getDaiyFortune() {
		return fortuneService.getFortune();
	}

}
