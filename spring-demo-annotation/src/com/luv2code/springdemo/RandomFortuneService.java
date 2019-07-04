package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
			"Good luck!",
			"Beware!",
			"ohhh yeah!"
	};
	
	private Random generator = new Random();
	
	@Override
	public String getFortune() {
		String fortune = data[generator.nextInt(data.length)];
		return fortune;
	}

}
