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
 * @version $Id: $Id
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
