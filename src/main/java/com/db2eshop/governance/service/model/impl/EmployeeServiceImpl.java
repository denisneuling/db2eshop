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

import com.db2eshop.governance.service.model.EmployeeService;
import com.db2eshop.model.Employee;
import com.db2eshop.persistence.EmployeeDao;

/**
 * <p>EmployeeServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	/** {@inheritDoc} */
	@Override
	public List<Employee> loadEntireTable() {
		return employeeDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Employee getById(Long id) {
		return employeeDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Employee entity) {
		employeeDao.update(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void save(Employee entity) {
		employeeDao.saveOrUpdate(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Employee entity) {
		employeeDao.delete(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Employee entity) {
		employeeDao.refresh(entity);		
	}

}
