package com.github.veeshostak.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCylceDemoApp {

	public static void main(String[] args) {
		// load Spring config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("BeanLifeCycle-applicationContext.xml");
		
		// get beans from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		// close context
		context.close();
	}

}
