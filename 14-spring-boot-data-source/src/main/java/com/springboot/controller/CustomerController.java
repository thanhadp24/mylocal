package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.persistence.Customer;
import com.springboot.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	@Qualifier("servicejpa")
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAll() {
		System.out.println("====>>> Customer#getAll ..");
		return customerService.getAll(0, 6);
	}
	
	@GetMapping("/customer/{id}")
	public Customer get(@PathVariable int id) {
		System.out.println("====>>> Customer#getById .. " + id);
		return customerService.get(id);
	}
	
	@GetMapping("/customer/email/{email}")
	public List<Customer> getByEmail(@PathVariable String email) {
		System.out.println("====>>> Customer#getByEmail .. " + email);
		return customerService.getByEmail(email);
	}
}