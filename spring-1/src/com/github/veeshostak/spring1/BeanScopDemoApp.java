package com.github.veeshostak.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// get bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if same reference
		boolean isSame = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object: " + isSame);
		System.out.println("\nMemory location for theCoach" + theCoach);
		System.out.println("\nMemory location for alphaCoach" + alphaCoach);
		
		context.close();
	}

}
