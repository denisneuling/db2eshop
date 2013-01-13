package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.ArticleTypeService;
import com.db2eshop.model.ArticleType;
import com.db2eshop.persistence.ArticleTypeDao;

/**
 * <p>ArticleTypeServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

	@Autowired
	private ArticleTypeDao articleTypeDao;
	
	/** {@inheritDoc} */
	@Override
	public List<ArticleType> loadEntireTable() {
		return articleTypeDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public ArticleType getById(Long id) {
		return articleTypeDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(ArticleType entity) {
		articleTypeDao.update(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void save(ArticleType entity) {
		articleTypeDao.saveOrUpdate(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void delete(ArticleType entity) {
		articleTypeDao.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(ArticleType entity) {
		articleTypeDao.refresh(entity);
	}

}
