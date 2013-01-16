package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.exception.OperationNotSupportedException;
import com.db2eshop.governance.service.model.BookingService;
import com.db2eshop.model.Booking;
import com.db2eshop.persistence.BookingDao;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public List<Booking> loadEntireTable() {
		return bookingDao.findAll();
	}

	@Override
	public Booking getById(Long id) {
		return bookingDao.findById(id);
	}

	@Override
	public void update(Booking entity) {
		throw new OperationNotSupportedException();		
	}

	@Override
	public void save(Booking entity) {
		throw new OperationNotSupportedException();		
	}

	@Override
	public void delete(Booking entity) {
		throw new OperationNotSupportedException();		
	}

	@Override
	public void refresh(Booking entity) {
		bookingDao.refresh(entity);
	}

}
