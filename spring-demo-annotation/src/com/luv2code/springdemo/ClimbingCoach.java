package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class ClimbingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Let's try to do this 7a+";
	}

}
