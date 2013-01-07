package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.models.Import;
import com.db2eshop.persistence.support.AbstractDao;


@Repository
public class ImportDao extends AbstractDao<Import> {

	@Autowired
	public ImportDao(SessionFactory sessionFactory) {
		super(sessionFactory, Import.class);
	}
}
