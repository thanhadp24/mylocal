package crm.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crm.backend.dao.CustomerDao;
import crm.backend.entity.Customer;

@Service 
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getAll(int offset, int rowCount) {
		return customerDao.getAll(offset, rowCount);
	}
	
	@Override
	@Transactional
	public List<Customer> getAll(int offset, int rowCount, String sort) {
		return customerDao.getAll(offset, rowCount, sort);
	}
	
	@Override
	@Transactional
	public List<Customer> getAll() {
		return customerDao.getAll();
	}
	
	@Override
	@Transactional
	public int countTotalOfRecords() {
		return customerDao.countTotalOfRecords();
	}
	
	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
	}
	
	@Override
	@Transactional
	public Customer get(int id) {
		return customerDao.get(id);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}
}
