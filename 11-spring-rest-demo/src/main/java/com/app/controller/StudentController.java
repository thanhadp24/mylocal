package com.app.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.Student;
import com.app.exception.handling.CustomErrorResponse;
import com.app.exception.handling.ElementNotFoundException;
import com.app.exception.handling.GlobalExceptionHandling;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {
	
	
	@GetMapping("/students")
	public List<Student> getAll() {
		return findAll();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		List<Student> students = findAll();
		Optional<Student> optStudent = students.stream()
				.filter(student -> student.getId()==studentId)
				.findFirst();
		if(!optStudent.isPresent()) {
			throw new ElementNotFoundException("student " + studentId + " not found!!!");
		}
		
		return optStudent.get();
	}
	
	
	
	public List<Student> findAll(){
		return Arrays.asList(
					new Student(1, "le van a"),
					new Student(2, "le van b"),
					new Student(3, "le van c"),
					new Student(4, "le van d")
				);
	}
}
