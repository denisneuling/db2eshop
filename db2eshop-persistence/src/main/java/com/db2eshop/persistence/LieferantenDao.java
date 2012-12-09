package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.models.support.Lieferanten;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
/**
 * <p>LieferantenDao class.</p>
 *
 * @author Denis Nuling (denisneuling@gmail.com)
 *
 */
public class LieferantenDao extends AbstractDao<Lieferanten>{

	/**
	 * <p>Constructor for LieferantenDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public LieferantenDao(SessionFactory sessionFactory){
		super(sessionFactory, Lieferanten.class);
	}
}
