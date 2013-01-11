package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.EmployeeService;
import com.db2eshop.model.Employee;
import com.db2eshop.persistence.EmployeeDao;

@Service
/**
 * <p>EmployeeServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
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
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void update(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Employee entity) {
		// TODO Auto-generated method stub
		
	}

}
