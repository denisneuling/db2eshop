package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.ArticleService;
import com.db2eshop.model.Article;
import com.db2eshop.persistence.ArticleDao;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articeDao;
	
	@Override
	public List<Article> loadEntireTable() {
		return articeDao.findAll();
	}

	@Override
	public Article getById(Long id) {
		return 	articeDao.findById(id);
	}

	@Override
	public void update(Article entity) {
		articeDao.update(entity);
	}

	@Override
	public void save(Article entity) {
		articeDao.saveOrUpdate(entity);		
	}

	@Override
	public void delete(Article entity) {
		articeDao.delete(entity);		
	}

	@Override
	public void refresh(Article entity) {
		articeDao.refresh(entity);
	}

}
