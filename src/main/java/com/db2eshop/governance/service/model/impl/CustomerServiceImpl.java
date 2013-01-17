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

import com.db2eshop.governance.service.model.CustomerService;
import com.db2eshop.model.Customer;
import com.db2eshop.persistence.CustomerDao;

/**
 * <p>CustomerServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	/** {@inheritDoc} */
	@Override
	public List<Customer> loadEntireTable() {
		return customerDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Customer getById(Long id) {
		return customerDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Customer entity) {
		customerDao.update(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void save(Customer entity) {
		customerDao.saveOrUpdate(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Customer entity) {
		customerDao.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Customer entity) {
		customerDao.refresh(entity);
	}

}
