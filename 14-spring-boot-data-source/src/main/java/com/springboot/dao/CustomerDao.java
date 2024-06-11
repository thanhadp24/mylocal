package com.springboot.dao;

import java.util.List;

import com.springboot.persistence.Customer;

public interface CustomerDao {
	List<Customer> getAll(int offset, int rowcount);
	
	List<Customer> getAll(int offset, int rowcount, String sort);

	int countTotalRecords();

	void save(Customer customer);

	Customer get(int id);

	void delete(int id);
}