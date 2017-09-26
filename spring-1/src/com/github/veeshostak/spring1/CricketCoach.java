package com.github.veeshostak.spring1;

public class CricketCoach implements Coach {
	// dependency (helper class)
	private FortuneService fortuneService;
	// literal value fields that will be injected
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg contsr");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	// setter method for literal value emailAdress injection
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}
	// setter method for literal value team injection
	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method setTeam");
		this.team = team;
	}

	// setter method for fortuneService injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Fast bowling practice for 20 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
