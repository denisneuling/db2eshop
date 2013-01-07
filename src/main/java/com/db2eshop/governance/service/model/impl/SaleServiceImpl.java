package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.governance.service.model.SaleService;
import com.db2eshop.model.Sale;
import com.db2eshop.persistence.SaleDao;

@Service
public class SaleServiceImpl implements SaleService{

	@Autowired
	private SaleDao saleDao;

	@Override
	public List<Sale> loadEntireTable() {
		return saleDao.findAll();
	}

	@Override
	public Sale getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Sale entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Sale entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sale entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Sale entity) {
		// TODO Auto-generated method stub
		
	}
}
