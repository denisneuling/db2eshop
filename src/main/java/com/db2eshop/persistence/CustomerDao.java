package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Customer;
import com.db2eshop.persistence.support.AbstractDao;

/**
 * <p>CustomerDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Repository
public class CustomerDao extends AbstractDao<Customer> {

	/**
	 * <p>Constructor for CustomerDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public CustomerDao(SessionFactory sessionFactory) {
		super(sessionFactory, Customer.class);
	}
}
