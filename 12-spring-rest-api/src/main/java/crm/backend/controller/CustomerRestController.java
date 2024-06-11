package crm.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crm.backend.entity.Customer;
import crm.backend.exception.ElementNotFoundException;
import crm.backend.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return customerService.getAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id){
		Optional<Customer> opt = Optional.ofNullable(customerService.get(id));
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new ElementNotFoundException("customer " + id + " not found!!!");
	}
	
	@PostMapping("/customers")
	public Customer add(@RequestBody Customer customer) {
		//JSON can have id (non-null, non-zero) or non-valid
		// Override id = 0 to make sure with post method will ignore id and always add
		// new customer
		customer.setId(0);
		customerService.save(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer update(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}
}
