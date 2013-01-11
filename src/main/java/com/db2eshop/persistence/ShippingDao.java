package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Shipping;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
/**
 * <p>ShippingDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ShippingDao extends AbstractDao<Shipping> {

	/**
	 * <p>Constructor for ShippingDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public ShippingDao(SessionFactory sessionFactory) {
		super(sessionFactory, Shipping.class);
	}
}
