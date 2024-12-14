package com.shopapp.admin.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopapp.admin.service.CustomerService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers/check_unique_email")
	public String checkUnique(@Param("id") Integer id, @Param("email") String email) {

		if(customerService.isEmailUnique(id, email)) {
			return "ok";
		}
		return "duplicated";
	}
}
