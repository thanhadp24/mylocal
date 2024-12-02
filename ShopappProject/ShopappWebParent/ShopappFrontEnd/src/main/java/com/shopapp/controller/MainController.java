package com.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopapp.service.CategoryService;

@Controller
public class MainController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public String viewHomepage(Model model) {
		model.addAttribute("categories", categoryService.getAllWithNoChildrens());
		
		return "index";
	}
}
