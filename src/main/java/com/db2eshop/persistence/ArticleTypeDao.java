package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.ArticleType;
import com.db2eshop.persistence.support.AbstractDao;

/**
 * <p>ArticleTypeDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Repository
public class ArticleTypeDao extends AbstractDao<ArticleType>{

	/**
	 * <p>Constructor for ArticleTypeDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public ArticleTypeDao(SessionFactory sessionFactory) {
		super(sessionFactory, ArticleType.class);
	}
}
