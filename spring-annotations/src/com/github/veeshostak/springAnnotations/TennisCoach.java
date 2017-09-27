package com.github.veeshostak.springAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("myTennisCoach")
// use default Bean Id
@Component
public class TennisCoach implements Coach {

	// dependency (helper class)
	private FortuneService fortuneService;
	
	// constructor injection
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
