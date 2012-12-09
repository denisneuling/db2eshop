package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.models.support.Lieferanten;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class LieferantenDao extends AbstractDao<Lieferanten>{

	@Autowired
	public LieferantenDao(SessionFactory sessionFactory){
		super(sessionFactory, Lieferanten.class);
	}
}
