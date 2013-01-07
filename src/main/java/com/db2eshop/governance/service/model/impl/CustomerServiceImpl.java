package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.CustomerService;
import com.db2eshop.model.Customer;
import com.db2eshop.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> loadEntireTable() {
		return customerDao.findAll();
	}

	@Override
	public Customer getById(Long id) {
		return customerDao.findById(id);
	}

	@Override
	public void update(Customer entity) {
		customerDao.update(entity);
	}

	@Override
	public void save(Customer entity) {
		customerDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(Customer entity) {
		customerDao.delete(entity);
	}

	@Override
	public void refresh(Customer entity) {
		customerDao.refresh(entity);
	}

}
