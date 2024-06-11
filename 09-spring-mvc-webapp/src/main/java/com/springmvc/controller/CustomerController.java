package com.springmvc.controller;

import static com.springmvc.common.Application.*;

import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.utils.SortUtils;
import com.springmvc.entity.Customer;
import com.springmvc.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String index(ModelMap modelMap, 
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "text", defaultValue = "") String text,
			@RequestParam(name = "sort", defaultValue = "first_name") String sort) {
		// step 1: count total of records
		
		int totalRecords = customerService.countTotalOfRecords();
		
		int totalPages = (int) Math.ceil(totalRecords*1.0/RECORDS_PER_PAGE);
		page = page < 1 ? 1 : page;
		page = page > totalPages ? totalPages : page; 
		
		int offset = (page - 1) * RECORDS_PER_PAGE;
		
		//List<Customer> customers = customerService.getAll(offset, RECORDS_PER_PAGE);
		List<Customer> customers = customerService.getAll(offset, RECORDS_PER_PAGE);
		
		customers.sort(Comparator.comparing(SortUtils.CUSTOMER_SORT_PROPERTIES.get(sort)));
		
		if(!text.trim().isEmpty()) {
			customers = customers.stream()
					 .filter(c -> {
						 return c.getFirstName().toLowerCase().contains(text.toLowerCase())
								 || c.getLastName().toLowerCase().contains(text.toLowerCase())
								 || c.getEmail().toLowerCase().contains(text.toLowerCase());
					 })
					 .toList();
		}
		
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("totalPages", totalPages); 
		modelMap.addAttribute("customers", customers);
		
		return CUSTOMER_INDEX_PAGE;
	}
	
	@GetMapping("/add")
	public String add(ModelMap modelMap) {
		// data binding
		modelMap.addAttribute("customer", new Customer());
		return CUSTOMER_FORM_PAGE;
	}
	
	@GetMapping("/update")
	public String update(ModelMap modelMap, @RequestParam("id") int id) {
		
		Customer customer = customerService.get(id);
		
		modelMap.addAttribute("customer", customer);
		
		return CUSTOMER_FORM_PAGE;
	}	
	
	@PostMapping("/save/success")
	public String save(@Valid @ModelAttribute("customer") Customer customer) {
		if(customer.getId() == null) {
			customer.setId(0);
		}
		
		customerService.save(customer);
		// contextPath/customer
		return CUSTOMER_REDIRECT;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		customerService.delete(id);
		
		return CUSTOMER_REDIRECT;
	}
}
