
package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.dao.CustomerRepository;
import com.springboot.persistence.Customer;

@Service(value = "servicejpa")
public class CustomerServiceSpringDataJpaImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAll(int offset, int rowcount) {
		// return customerRepository.findAll();
		// page 0: 0 rowcount
		// pagr 1: rowcount, rowcount
		return customerRepository.findAll(PageRequest.of(1, rowcount)).getContent();
	}
	
	@Override
	public Customer get(int id) {
		Optional<Customer> optId = customerRepository.findById(id);
		return optId.orElse(null);
	}

	@Override
	public List<Customer> getByEmail(String email) {
		return customerRepository.findCustomersByEmail(email);
	}
}
