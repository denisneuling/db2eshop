package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.ShippingService;
import com.db2eshop.model.Shipping;
import com.db2eshop.persistence.ShippingDao;

@Service
/**
 * <p>ShippingServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
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
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void update(Shipping entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Shipping entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Shipping entity) {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Shipping entity) {
		// TODO Auto-generated method stub
		
	}
}
