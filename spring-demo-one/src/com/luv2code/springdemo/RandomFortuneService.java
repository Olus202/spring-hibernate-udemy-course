package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunesList = {"That's the best day to make this 7c route!",
	                                 "You can do whatever you want!",
	                                 "Good luck my dear climber!"};
	
	private Random randomGenerator = new Random();

	@Override
	public String getFortune() {
		int index = randomGenerator.nextInt(fortunesList.length);
		return fortunesList[index];
	}

}
