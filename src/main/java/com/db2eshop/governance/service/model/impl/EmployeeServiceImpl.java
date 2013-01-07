package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.EmployeeService;
import com.db2eshop.model.Employee;
import com.db2eshop.persistence.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> loadEntireTable() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Employee entity) {
		// TODO Auto-generated method stub
		
	}

}
