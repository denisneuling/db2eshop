package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.CustomerService;
import com.db2eshop.model.Customer;
import com.db2eshop.persistence.CustomerDao;

@Service
/**
 * <p>CustomerServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
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
