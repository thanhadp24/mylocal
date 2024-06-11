package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.Customer;

public interface CustomerDao {
	List<Customer> getAll(int offset, int rowCount);

	List<Customer> getAll(int offset, int rowCount, String sort);
	
	int countTotalOfRecords();

	void save(Customer customer);
	
	Customer get(int id);

	void delete(int id);
}
