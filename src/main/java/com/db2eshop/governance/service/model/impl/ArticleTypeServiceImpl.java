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

import com.db2eshop.governance.service.model.ArticleTypeService;
import com.db2eshop.model.ArticleType;
import com.db2eshop.persistence.ArticleTypeDao;

/**
 * <p>ArticleTypeServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
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
