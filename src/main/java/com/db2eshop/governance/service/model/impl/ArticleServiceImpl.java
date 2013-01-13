package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.ArticleService;
import com.db2eshop.model.Article;
import com.db2eshop.persistence.ArticleDao;

/**
 * <p>ArticleServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articeDao;
	
	/** {@inheritDoc} */
	@Override
	public List<Article> loadEntireTable() {
		return articeDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Article getById(Long id) {
		return 	articeDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Article entity) {
		articeDao.update(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void save(Article entity) {
		articeDao.saveOrUpdate(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Article entity) {
		articeDao.delete(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Article entity) {
		articeDao.refresh(entity);
	}

}
