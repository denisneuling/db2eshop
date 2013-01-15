package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Turnover;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
/**
 * <p>TurnoverDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class TurnoverDao extends AbstractDao<Turnover> {

	/**
	 * <p>Constructor for TurnoverDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public TurnoverDao(SessionFactory sessionFactory) {
		super(sessionFactory, Turnover.class);
	}
}
