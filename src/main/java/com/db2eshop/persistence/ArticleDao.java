package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Article;
import com.db2eshop.persistence.support.AbstractDao;

/**
 * <p>ArticleDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@Repository
public class ArticleDao extends AbstractDao<Article> {

	/**
	 * <p>Constructor for ArticleDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public ArticleDao(SessionFactory sessionFactory) {
		super(sessionFactory, Article.class);
	}
}
