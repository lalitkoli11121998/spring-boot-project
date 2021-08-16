package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	
	

	@GetMapping("/hello")
	public String sayHello(Model thmodel) {
		thmodel.addAttribute("theDate", new java.util.Date());
		return "helloworld";  //as we dont need to configure the thymleaf pages 
		                      //as spring automatically configure this because we have used thymleaf dependency	                      //basicaly it find the thymleaf template in the template directory
	}
}
