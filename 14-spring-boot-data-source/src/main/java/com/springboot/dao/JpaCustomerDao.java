package com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.persistence.Customer;

@Repository
public class JpaCustomerDao implements CustomerDao {

	// EntityManager: Object from JPA --> Auto Configure from Data Source
	private EntityManager entityManager;

	@Autowired
	public JpaCustomerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override //  TODO: DEMO
	public List<Customer> getAll(int offset, int rowcount) {
		TypedQuery<Customer> typeQuery = 
					entityManager.createQuery("FROM Customer", Customer.class)
						.setFirstResult(offset)
						.setMaxResults(rowcount);
		return 	typeQuery.getResultList();
	}

	@Override
	public List<Customer> getAll(int offset, int rowcount, String sort) {
		Session session = entityManager.unwrap(Session.class);
		return session.createNativeQuery("SELECT * FROM customer LIMIT :offset, :rowcount" + sort, Customer.class)
				.setParameter("offset", offset).setParameter("rowcount", rowcount).getResultList();
	}

	@Override
	public int countTotalRecords() {
		Session session = entityManager.unwrap(Session.class);
		final String sql = "SELECT COUNT(*) totalRecords FROM customer";
		return (int) session.createNativeQuery(sql)
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
		session.createNativeQuery("DELETE FROM customer WHERE id=:id").setParameter("id", id).executeUpdate();
	}
}