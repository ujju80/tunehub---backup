package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/Login") 
	public String Login() {
		return "Login";
	}
	
	@GetMapping("/Registration") 
	public String Registration() {
		return "Registration";
	}
	
	@GetMapping("/validate") 
	public String validate() {
		return "home";
	}
	
	@GetMapping("/NewSong") 
	public String addSong() {
		return "NewSong";
	}
	

}
