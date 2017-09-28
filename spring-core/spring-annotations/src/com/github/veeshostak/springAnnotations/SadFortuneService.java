package com.github.veeshostak.springAnnotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "It's a sad day today";
	}

}
