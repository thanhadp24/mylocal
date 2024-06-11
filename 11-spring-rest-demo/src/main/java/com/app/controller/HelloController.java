package com.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin
public class HelloController {
	
	@GetMapping("/hello")
	// endpoint
	public String hello() {
		return "-- Rest api - Hello world";
	}
	
}
