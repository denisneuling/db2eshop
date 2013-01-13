package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.SaleService;
import com.db2eshop.model.Sale;
import com.db2eshop.persistence.SaleDao;

/**
 * <p>SaleServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@Service
public class SaleServiceImpl implements SaleService{

	@Autowired
	private SaleDao saleDao;

	/** {@inheritDoc} */
	@Override
	public List<Sale> loadEntireTable() {
		return saleDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Sale getById(Long id) {
		return saleDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Sale entity) {
		saleDao.update(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Sale entity) {
		saleDao.saveOrUpdate(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Sale entity) {
		saleDao.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Sale entity) {
		saleDao.refresh(entity);
	}
}
