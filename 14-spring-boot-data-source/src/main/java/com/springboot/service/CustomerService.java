package com.springboot.service;

import java.util.List;

import com.springboot.persistence.Customer;

public interface CustomerService {
	List<Customer> getAll(int offset, int rowcount);
	List<Customer> getByEmail(String email);
	Customer get(int id);
	
}