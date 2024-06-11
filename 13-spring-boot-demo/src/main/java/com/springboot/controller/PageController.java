package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

	@GetMapping
	public String startPage() {
		return "Welcome to start spring boot";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to spring boot";
	}
}
