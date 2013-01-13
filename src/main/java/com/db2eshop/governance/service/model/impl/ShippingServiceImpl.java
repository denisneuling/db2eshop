package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.ShippingService;
import com.db2eshop.model.Shipping;
import com.db2eshop.persistence.ShippingDao;

/**
 * <p>ShippingServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Service
public class ShippingServiceImpl implements ShippingService{

	@Autowired
	private ShippingDao shippingDao;

	/** {@inheritDoc} */
	@Override
	public List<Shipping> loadEntireTable() {
		return shippingDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Shipping getById(Long id) {
		return shippingDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Shipping entity) {
		shippingDao.update(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Shipping entity) {
		shippingDao.saveOrUpdate(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Shipping entity) {
		shippingDao.delete(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Shipping entity) {
		shippingDao.refresh(entity);		
	}
}
