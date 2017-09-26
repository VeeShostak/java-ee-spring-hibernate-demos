package com.github.veeshostak.spring1;

public class TrackCoach implements Coach {
	
	// dependency (helper class)
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	// constructor for dependency injection
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	
	@Override
	public String getDailyWorkout() {
		return "Run 3 miles";
	}

	@Override
	public String getDailyFortune() {
		// use helper class to get fortune
		return "You'll be fine: " + fortuneService.getFortune();
	}
	

}
