package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.Customer;

@Repository
public class HibernateCustomerDao implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getAll(int offset, int rowCount) {
		Session session = sessionFactory.getCurrentSession();
		final String sql = "SELECT * FROM customer LIMIT :poffset, :prowCount";
		return session.createNativeQuery(sql, Customer.class)
			   .setParameter("poffset", offset)
			   .setParameter("prowCount", rowCount)
			   .getResultList();
	}
	
	@Override
	public List<Customer> getAll(int offset, int rowCount, String sort) {
		Session session = sessionFactory.getCurrentSession();
		final String sql = "SELECT * FROM customer LIMIT :poffset, :prowCount";
		return session.createNativeQuery(sql, Customer.class)
				.setParameter("poffset", offset)
			    .setParameter("prowCount", rowCount)
			    .getResultList();
	}
	
	@Override
	public int countTotalOfRecords() {
		Session session = sessionFactory.getCurrentSession();
		final String sql = "SELECT COUNT(*) totalRecords FROM customer";
		return (int) session.createNativeQuery(sql)
			   .addScalar("totalRecords", IntegerType.INSTANCE)
			   .getSingleResult();
	}
	
	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}
	
	@Override
	public Customer get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("DELETE FROM customer WHERE id = :id")
			   .setParameter("id", id)
			   .executeUpdate();
	}
}
