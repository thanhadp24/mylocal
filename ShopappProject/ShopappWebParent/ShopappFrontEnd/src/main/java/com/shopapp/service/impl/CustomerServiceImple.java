package com.shopapp.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopapp.common.entity.Country;
import com.shopapp.common.entity.Customer;
import com.shopapp.repository.CountryRepository;
import com.shopapp.repository.CustomerRepository;
import com.shopapp.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImple implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired PasswordEncoder encoder;
	
	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAllByOrderByNameAsc();
	}
	
	@Override
	public boolean isUniqueEmail(String email) {
		return customerRepository.findByEmail(email) == null;
	}

	@Override
	public void registerCustomer(Customer customer) {
		encodePassword(customer);
		customer.setCreatedAt(new Date());
		customer.setEnabled(false);
		
		String random = RandomStringUtils.randomAlphabetic(64);
		customer.setVerificationCode(random);
		
		customerRepository.save(customer);
	}
	
	@Override
	public boolean verify(String verificationCode) {
		Customer customer = customerRepository.findByVerificationCode(verificationCode);
		
		if(customer == null || customer.isEnabled()) {
			return false;
		}else {
			customerRepository.enable(customer.getId());
			return true;
		}
		
	}

	private void encodePassword(Customer customer) {
		String encodedPass = encoder.encode(customer.getPassword());
		customer.setPassword(encodedPass);
	}
}
