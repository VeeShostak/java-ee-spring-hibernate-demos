package com.github.veeshostak.spring1;

public class MyApp {

	public static void main(String[] args) {
		
		// not configurable, needs to be hard coded
		// better to read implementation name from config file and 
		// then swap by changin in the config file
		
		//Coach theCoach = new TrackCoach();
		Coach theCoach = new BaseBallCoach();
		
		System.out.println(theCoach.getDailyWorkout());
	}

}
