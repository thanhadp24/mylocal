package com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.persistence.Customer;

@Repository
public class HibernateCustomerDao implements CustomerDao{

	// EntityManager: Object from JPA --> Auto Configure from Data Source
	// EntityManager: using Hibernate's Session --> entityManager.unwrap(Session.class);
	private EntityManager entityManager;
	
	@Autowired
	public HibernateCustomerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Customer> getAll(int offset, int rowcount) {
		Session session = entityManager.unwrap(Session.class);
		return session.createNativeQuery("SELECT * FROM customer LIMIT :offset, :rowcount", Customer.class)
					  .setParameter("offset", offset)
					  .setParameter("rowcount", rowcount)
				      .getResultList();
	}
	
	@Override
	public List<Customer> getAll(int offset, int rowcount, String sort) {
		Session session = entityManager.unwrap(Session.class);
		return session.createNativeQuery("SELECT * FROM customer LIMIT :offset, :rowcount" + sort, Customer.class)
					  .setParameter("offset", offset)
					  .setParameter("rowcount", rowcount)
				      .getResultList();
	}
	
	@Override
	public int countTotalRecords() {
		Session session = entityManager.unwrap(Session.class);
		final String sql = "SELECT COUNT(*) totalRecords FROM customer";
		return (int)session.createNativeQuery(sql)
					  .addScalar("totalRecords", IntegerType.INSTANCE)
					  .getSingleResult();
	}
	
	@Override
	public void save(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
	}
	
	
	@Override
	public Customer get(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Customer.class, id);
	}
	
	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		session.createNativeQuery("DELETE FROM customer WHERE id=:id")
			   .setParameter("id", id)
			   .executeUpdate();
	}
}