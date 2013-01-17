/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * 
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
