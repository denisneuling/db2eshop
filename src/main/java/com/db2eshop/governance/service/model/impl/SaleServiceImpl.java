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

import com.db2eshop.governance.service.model.SaleService;
import com.db2eshop.model.Sale;
import com.db2eshop.persistence.SaleDao;

/**
 * <p>SaleServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Service
public class SaleServiceImpl implements SaleService{

	@Autowired
	private SaleDao saleDao;

	/** {@inheritDoc} */
	@Override
	public List<Sale> loadEntireTable() {
		return saleDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Sale getById(Long id) {
		return saleDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Sale entity) {
		saleDao.update(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Sale entity) {
		saleDao.save(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Sale entity) {
		saleDao.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Sale entity) {
		saleDao.refresh(entity);
	}
}
