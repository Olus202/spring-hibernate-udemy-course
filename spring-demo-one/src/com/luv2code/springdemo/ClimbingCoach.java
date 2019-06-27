package com.luv2code.springdemo;

public class ClimbingCoach implements Coach {

	private FortuneService fortuneService;
	
	public ClimbingCoach() {
		
	}
	
	public ClimbingCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Lets do some 6b+ route";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
