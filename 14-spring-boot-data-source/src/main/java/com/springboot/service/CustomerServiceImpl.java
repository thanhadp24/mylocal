
package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.dao.CustomerDao;
import com.springboot.persistence.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	@Qualifier("jpaCustomerDao")
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAll(int offset, int rowcount) {
		return customerDao.getAll(offset, rowcount);
	}
	
	@Override
	public Customer get(int id) {
		return null;
	}
	
	@Override
	public List<Customer> getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
