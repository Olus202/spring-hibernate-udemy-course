package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it:" + fortuneService.getFortune();
	}
	
	public void doMyStartupThings() {
		System.out.println("TrackCoach: inside the doMyStartupThings");
	}
	
	public void doMyCleanupThings() {
		System.out.println("TrackCoach: inside the doMyCleanupThings");
	}

}
