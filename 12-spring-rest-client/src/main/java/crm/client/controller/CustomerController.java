package crm.client.controller;

import static crm.client.common.Application.CUSTOMER_FORM_PAGE;
import static crm.client.common.Application.CUSTOMER_INDEX_PAGE;
import static crm.client.common.Application.CUSTOMER_REDIRECT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crm.client.bean.Customer;
import crm.client.service.CustomerRestService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerRestService service;

	@GetMapping
	public String index(ModelMap modelMap) {
		List<Customer> customers = service.getAll();
		modelMap.addAttribute("customers", customers);
		
		return CUSTOMER_INDEX_PAGE;
	}

	// http://localhost:8080/09-spring-mvc-webapp/customer/add
	@GetMapping("/add")
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("customer", new Customer());
		return CUSTOMER_FORM_PAGE;
	}

	@PutMapping("/update")
	public String update(ModelMap modelMap, @RequestParam("id") int id) {

		return CUSTOMER_FORM_PAGE;
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		service.save(customer);
		return CUSTOMER_REDIRECT;
	}

	@DeleteMapping("/delete")
	public String delete(ModelMap modelMap, @RequestParam("id") int id) {
		return CUSTOMER_REDIRECT;
	}
}