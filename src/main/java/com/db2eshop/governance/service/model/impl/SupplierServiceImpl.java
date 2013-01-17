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

import com.db2eshop.governance.service.model.SupplierService;
import com.db2eshop.model.Supplier;
import com.db2eshop.persistence.SupplierDao;

/**
 * <p>SupplierServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao supplierDao;

	/** {@inheritDoc} */
	@Override
	public List<Supplier> loadEntireTable() {
		return supplierDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Supplier getById(Long id) {
		return supplierDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Supplier entity) {
		supplierDao.update(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Supplier entity) {
		supplierDao.saveOrUpdate(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Supplier entity) {
		supplierDao.delete(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Supplier entity) {
		supplierDao.refresh(entity);		
	}
}
