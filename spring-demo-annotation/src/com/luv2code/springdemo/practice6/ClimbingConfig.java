package com.luv2code.springdemo.practice6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClimbingConfig {

	@Bean
	public FortuneService climbingFrtuneService() {
		return new ClimbingFortuneService();
	}
	
	@Bean
	public Coach climbingCoach() {
		return new ClimbingCoach(climbingFrtuneService());
	}
}
