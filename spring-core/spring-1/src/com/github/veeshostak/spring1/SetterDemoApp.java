package com.github.veeshostak.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// ========================
		// start call methods
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// literal values test
		System.out.println(theCoach.getTeam());
		System.out.println(theCoach.getEmailAddress());
		// ========================
		// end call methods
		
		// close context
		context.close();

	}

}
