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
 * @version $Id: $Id
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
