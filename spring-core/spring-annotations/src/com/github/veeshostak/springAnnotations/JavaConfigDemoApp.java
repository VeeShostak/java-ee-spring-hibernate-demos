package com.github.veeshostak.springAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

public static void main(String[] args) {
		
		// load the spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from spring container
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		
		System.out.println(myCoach.getDailyFortune());

		context.close();
	}

}
