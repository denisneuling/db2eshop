package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.SaleService;
import com.db2eshop.model.Sale;
import com.db2eshop.persistence.SaleDao;

@Service
/**
 * <p>SaleServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
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
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void update(Sale entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Sale entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Sale entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Sale entity) {
		// TODO Auto-generated method stub
		
	}
}
