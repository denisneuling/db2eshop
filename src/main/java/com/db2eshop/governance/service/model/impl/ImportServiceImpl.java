package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.ImportService;
import com.db2eshop.model.Import;
import com.db2eshop.persistence.ImportDao;

/**
 * <p>ImportServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Service
public class ImportServiceImpl implements ImportService{

	@Autowired
	private ImportDao importDao;

	/** {@inheritDoc} */
	@Override
	public List<Import> loadEntireTable() {
		return importDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Import getById(Long id) {
		return importDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Import entity) {
		importDao.update(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Import entity) {
		importDao.saveOrUpdate(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Import entity) {
		importDao.delete(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Import entity) {
		importDao.refresh(entity);		
	}
}
