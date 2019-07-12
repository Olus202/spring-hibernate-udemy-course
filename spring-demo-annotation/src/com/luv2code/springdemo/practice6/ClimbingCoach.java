package com.luv2code.springdemo.practice6;

public class ClimbingCoach implements com.luv2code.springdemo.practice6.Coach {

	private FortuneService fortuneService;
	
	public ClimbingCoach (FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Handboard training";
	}

	@Override
	public String getDaiyFortune() {
		return fortuneService.getFortune();
	}

}
