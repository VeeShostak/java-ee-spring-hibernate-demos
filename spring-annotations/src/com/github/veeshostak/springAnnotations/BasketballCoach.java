package com.github.veeshostak.springAnnotations;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Practice Dribbling for 45 minutes";
	}

}
