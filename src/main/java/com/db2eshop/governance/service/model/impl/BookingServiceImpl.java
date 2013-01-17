/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.db2eshop.governance.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2eshop.exception.OperationNotSupportedException;
import com.db2eshop.governance.service.model.BookingService;
import com.db2eshop.model.Booking;
import com.db2eshop.persistence.BookingDao;

@Service
/**
 * <p>BookingServiceImpl class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDao bookingDao;
	
	/** {@inheritDoc} */
	@Override
	public List<Booking> loadEntireTable() {
		return bookingDao.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Booking getById(Long id) {
		return bookingDao.findById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Booking entity) {
		throw new OperationNotSupportedException();		
	}

	/** {@inheritDoc} */
	@Override
	public void save(Booking entity) {
		throw new OperationNotSupportedException();		
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Booking entity) {
		throw new OperationNotSupportedException();		
	}

	/** {@inheritDoc} */
	@Override
	public void refresh(Booking entity) {
		bookingDao.refresh(entity);
	}

}
