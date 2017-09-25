package com.github.veeshostak.spring1;

public class BaseBallCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "20 minute batting practice";
	}
}
