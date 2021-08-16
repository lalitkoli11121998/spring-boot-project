package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
		
	// expose "/" that return "Hello World"
	
	//import properties for : caoch name and coach game
	@Value("${coach.name}")
	private String  coachname;
	
	@Value("${coach.game}")
	private String  coachgame;
	
	
	@GetMapping("/teaminfo")
	public String gatteameinfo() {
		return "coach " + coachname + "game " + coachgame;
	}
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "run daily to " + LocalDateTime.now();
	}
	
}












