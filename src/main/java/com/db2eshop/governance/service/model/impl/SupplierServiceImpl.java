package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.SupplierService;
import com.db2eshop.model.Supplier;
import com.db2eshop.persistence.SupplierDao;

@Service
/**
 * <p>SupplierServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
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
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void update(Supplier entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Supplier entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Supplier entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Supplier entity) {
		// TODO Auto-generated method stub
		
	}
	
	
}
