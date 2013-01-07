package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Shipping;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class ShippingDao extends AbstractDao<Shipping> {

	@Autowired
	public ShippingDao(SessionFactory sessionFactory) {
		super(sessionFactory, Shipping.class);
	}
}
