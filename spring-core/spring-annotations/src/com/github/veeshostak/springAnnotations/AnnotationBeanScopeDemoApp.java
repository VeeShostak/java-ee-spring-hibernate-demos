package com.github.veeshostak.springAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// get beans from spring container
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		Coach otherCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean isSame = (myCoach == otherCoach);
		
		System.out.println("Point ot same object? " + isSame );
		
		System.out.println("Mem location myCoach " + myCoach );
		System.out.println("Mem location otherCoach " + otherCoach );
		
		context.close();
		
		
	}

}
