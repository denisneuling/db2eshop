package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Import;
import com.db2eshop.persistence.support.AbstractDao;


/**
 * <p>ImportDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@Repository
public class ImportDao extends AbstractDao<Import> {

	/**
	 * <p>Constructor for ImportDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public ImportDao(SessionFactory sessionFactory) {
		super(sessionFactory, Import.class);
	}
}
