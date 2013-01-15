package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.exception.OperationNotSupportedException;
import com.db2eshop.governance.service.model.TurnoverService;
import com.db2eshop.model.Turnover;
import com.db2eshop.persistence.TurnoverDao;

@Service
public class TurnoverServiceImpl implements TurnoverService{

	@Autowired
	private TurnoverDao turnoverDao;
	
	@Override
	public List<Turnover> loadEntireTable() {
		return turnoverDao.findAll();
	}

	@Override
	public Turnover getById(Long id) {
		return turnoverDao.findById(id);
	}

	@Override
	public void update(Turnover entity) {
		throw new OperationNotSupportedException();
	}

	@Override
	public void save(Turnover entity) {
		throw new OperationNotSupportedException();
	}

	@Override
	public void delete(Turnover entity) {
		throw new OperationNotSupportedException();
	}

	@Override
	public void refresh(Turnover entity) {
		turnoverDao.refresh(entity);
	}

}
