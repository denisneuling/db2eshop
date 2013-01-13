package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Sale;
import com.db2eshop.persistence.support.AbstractDao;

/**
 * <p>SaleDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@Repository
public class SaleDao extends AbstractDao<Sale> {

	/**
	 * <p>Constructor for SaleDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public SaleDao(SessionFactory sessionFactory) {
		super(sessionFactory, Sale.class);
	}
}
