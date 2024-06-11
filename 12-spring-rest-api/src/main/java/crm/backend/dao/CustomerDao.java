package crm.backend.dao;

import java.util.List;

import crm.backend.entity.Customer;

public interface CustomerDao {
	List<Customer> getAll(int offset, int rowCount);

	List<Customer> getAll(int offset, int rowCount, String sort);
	
	List<Customer> getAll();
	
	Customer get(int id);
	
	int countTotalOfRecords();

	void save(Customer customer);

	void delete(int id);
}
