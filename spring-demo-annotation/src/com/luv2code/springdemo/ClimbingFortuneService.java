package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClimbingFortuneService implements FortuneService {
	
	@Value("${service.a}")
	private String a;
	
	@Value("${service.b}")
	private String b;
	
	@Value("${service.c}")
	private String c;
	
	@Value("${service.d}")
	private String d;
	
	private String[] data;
	
	private Random randomGen = new Random();
	
	@PostConstruct
	private void setupMyData() {
		 data = new String[4];
		 data[0] = a;
		 data[1] = b;
		 data[2] = c;
		 data[3] = d;
	}
	
	@Override
	public String getFortune() {
		int index = randomGen.nextInt(data.length);
		String service = data[index];
		
		return service;
	}

}
