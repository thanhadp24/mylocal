package crm.client.service;

import java.util.List;

import crm.client.bean.Customer;

public interface CustomerRestService {

	List<Customer> getAll();
	
	Customer get(int id);
	
	void save(Customer customer);
	
	void delete(int id);
}
