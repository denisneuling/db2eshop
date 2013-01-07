package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Article;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class ArticleDao extends AbstractDao<Article> {

	@Autowired
	public ArticleDao(SessionFactory sessionFactory) {
		super(sessionFactory, Article.class);
	}
}
