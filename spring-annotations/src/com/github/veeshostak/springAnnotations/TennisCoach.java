package com.github.veeshostak.springAnnotations;

import org.springframework.stereotype.Component;

//@Component("myTennisCoach")
// use default Bean Id
@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Practice backhand volley";
	}

}
