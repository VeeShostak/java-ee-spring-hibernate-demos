package com.github.veeshostak.spring1;

public class BaseBallCoach implements Coach {
	
	// dependency (helper class)
	private FortuneService fortuneService;
	
	// constructor for dependency injection
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	public BaseBallCoach() {
		
	}

	@Override
	public String getDailyWorkout() {
		return "20 minute batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use helper class to get fortune
		return fortuneService.getFortune();
	}
}
