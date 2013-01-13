package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Supplier;
import com.db2eshop.persistence.support.AbstractDao;

/**
 * <p>SupplierDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Repository
public class SupplierDao extends AbstractDao<Supplier> {

	/**
	 * <p>Constructor for SupplierDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public SupplierDao(SessionFactory sessionFactory) {
		super(sessionFactory, Supplier.class);
	}
}
