package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.models.ArticleType;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class ArticleTypeDao extends AbstractDao<ArticleType> {

	@Autowired
	public ArticleTypeDao(SessionFactory sessionFactory) {
		super(sessionFactory, ArticleType.class);
	}
}
