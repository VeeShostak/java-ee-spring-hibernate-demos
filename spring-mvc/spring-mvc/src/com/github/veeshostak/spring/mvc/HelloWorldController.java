package com.github.veeshostak.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// show initial html form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// process html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
}
