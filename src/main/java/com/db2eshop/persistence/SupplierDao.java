package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Supplier;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class SupplierDao extends AbstractDao<Supplier> {

	@Autowired
	public SupplierDao(SessionFactory sessionFactory) {
		super(sessionFactory, Supplier.class);
	}
}
