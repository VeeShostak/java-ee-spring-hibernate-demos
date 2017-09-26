package com.github.veeshostak.spring1;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "A new voyage will fill your life with untold memories";
	}

}
