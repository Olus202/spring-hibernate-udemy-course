package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TenisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand vollay";
	}

}
