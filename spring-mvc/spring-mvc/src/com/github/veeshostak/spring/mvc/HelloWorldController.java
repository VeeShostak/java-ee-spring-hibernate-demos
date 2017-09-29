package com.github.veeshostak.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
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
	
	// read form data and
	// add data to the modal
	@RequestMapping("/processFormVersionTwo")
	public String makeTextShout(HttpServletRequest request, Model model) {
		// read the request parameter from the html form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create message and add to the modal
		String result = " the name is " + theName;
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
		// read form data and
		// add data to the modal
		@RequestMapping("/processFormVersionThree")
		public String makeTextShoutVersionThree(
				@RequestParam("studentName") String theName, 
				Model model) {
			
			
			// convert the data to all caps
			theName = theName.toUpperCase();
			
			// create message and add to the modal
			String result = " the name is " + theName;
			model.addAttribute("message", result);
			
			return "helloworld";
		}
	
	
}
