package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.common.Application;
import com.springmvc.model.MockupData;
import com.springmvc.model.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		// data binding
		
		model.addAttribute("student", new Student());
		
		// select option
		model.addAttribute("countries", MockupData.countries());
		
		// radio button
		model.addAttribute("languages", MockupData.languages());
		
		// check boxes
		model.addAttribute("operatingSystems", MockupData.operatingSystems());
		
		return Application.STUDENT_FORM_PAGE;
	}
	
	@PostMapping("/processForm")
	public String process(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("student", student);
		return Application.STUDENT_SUCCESS_PAGE;
	}
	
//	@PostMapping("/processForm")
//	public String processForm(
//			@RequestParam String fullname,
//			@RequestParam("age") int age, 
//			Model model) {
//
//		model.addAttribute("fullname", fullname);
//		model.addAttribute("age", age);
//		
//		return Application.STUDENT_SUCCESS_PAGE;
//	}
}
