package com.shopapp.service;

import java.util.List;

import com.shopapp.common.entity.Country;
import com.shopapp.common.entity.Customer;

public interface CustomerService {

	List<Country> getAllCountries();
	
	boolean isUniqueEmail(String email);
	
	void registerCustomer(Customer customer);
	
	boolean verify(String verificationCode);
}
