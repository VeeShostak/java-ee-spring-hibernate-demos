package com.github.veeshostak.springAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("myTennisCoach")
// use default Bean Id

@Component
@Scope("prototype") // change to singleton for destructor to execute
public class TennisCoach implements Coach {

	// dependency (helper class)
	// Field injection using Java Reflection.
	// Qualifier uses default bean id
	@Autowired
	@Qualifier("fileRandomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoach: inside defualt constructor");
	}
	
	/*
	// constructor injection (searches for class that implements a fortuneService interface)
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	// setter injection (searches for class that implements a fortuneService interface)
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside setFortuneService");
		fortuneService = theFortuneService;
	}
	*/
	@PostConstruct
	public void doStartup() {
		System.out.println("inside doStartup");
	}
	
	@PreDestroy
	public void doCleanup() {
		System.out.println("inside doCleanup");
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
