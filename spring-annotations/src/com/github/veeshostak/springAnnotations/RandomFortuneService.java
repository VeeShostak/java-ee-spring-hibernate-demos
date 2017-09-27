package com.github.veeshostak.springAnnotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create a random number generator
		private Random myRandom = new Random();
		
		private String[] fortunes = {
				"A golden egg of opportunity falls into your lap this month",
				"A feather in the hand is better than a bird in the air",
				"Allow compassion to guide your decisions"	
		};
		
		@Override
		public String getFortune() {
			// TODO Auto-generated method stub
			int randomNum = myRandom.nextInt(fortunes.length);
			String selectedFortune = fortunes[randomNum];
			return selectedFortune;
		}

}
