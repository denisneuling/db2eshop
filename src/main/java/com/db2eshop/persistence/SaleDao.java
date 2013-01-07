package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Sale;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class SaleDao extends AbstractDao<Sale> {

	@Autowired
	public SaleDao(SessionFactory sessionFactory) {
		super(sessionFactory, Sale.class);
	}
}
