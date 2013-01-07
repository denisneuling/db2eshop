package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Customer;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class CustomerDao extends AbstractDao<Customer> {

	@Autowired
	public CustomerDao(SessionFactory sessionFactory) {
		super(sessionFactory, Customer.class);
	}
}
