package com.github.veeshostak.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		// config file adds on prefix and sufffix
		return "main-menu"; 
	}
}
