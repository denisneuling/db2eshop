package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.ArticleTypeService;
import com.db2eshop.model.ArticleType;
import com.db2eshop.persistence.ArticleTypeDao;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

	@Autowired
	private ArticleTypeDao articleTypeDao;
	
	@Override
	public List<ArticleType> loadEntireTable() {
		return articleTypeDao.findAll();
	}

	@Override
	public ArticleType getById(Long id) {
		return articleTypeDao.findById(id);
	}

	@Override
	public void update(ArticleType entity) {
		articleTypeDao.update(entity);
	}

	@Override
	public void save(ArticleType entity) {
		articleTypeDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(ArticleType entity) {
		articleTypeDao.delete(entity);
	}

	@Override
	public void refresh(ArticleType entity) {
		articleTypeDao.refresh(entity);
	}

}
