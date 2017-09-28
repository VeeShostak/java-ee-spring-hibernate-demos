package com.github.veeshostak.springAnnotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;


@Component
public class FileRandomFortuneService implements FortuneService {
	
	private Random myRandom = new Random();
	
	private List<String> fortunesList;
	private String fileName = "src/fortunes.txt";

	public FileRandomFortuneService() {

		File theFile = new File(fileName);

		System.out.println("File exists: " + theFile.exists());
		
		//System.out.println(System.getProperty("user.dir"));
		
		fortunesList = new ArrayList<String>();
		
		// read fortunes from file
		try (BufferedReader br = new BufferedReader(
				new FileReader(theFile))) {
			
			String line;

			while ((line = br.readLine()) != null) {
				fortunesList.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void doCleanup() {
		fortunesList.forEach(item -> { 
			System.out.println(item);
		});
	}
	
		
	@Override
	public String getFortune() {
		// pick a random string from the array
		int randomNum = myRandom.nextInt(fortunesList.size());

		String selectedFortune = fortunesList.get(randomNum);

		return selectedFortune;
	}

}
