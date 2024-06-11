package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.persistence.Customer;

@RepositoryRestResource(path = "ctms")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	List<Customer> findCustomersByEmail(String email);
	
	@Query("SELECT c FROM Customer c WHERE c.email = :email")
	List<Customer> getCustomersByEmail(@Param("email") String email);
}