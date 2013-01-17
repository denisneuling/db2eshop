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
package com.db2eshop.gui.component.table;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.BookingService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Booking;

/**
 * <p>BookingTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@UIFor(Booking.class)
@Component
public class BookingTable extends GenericTable<Booking>{
	private static final long serialVersionUID = 7368521561280743848L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private BookingService bookingService;
	
	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		this.ready = false;
	}
	
	/**
	 * <p>setup.</p>
	 */
	public void setup(){
		this.ready = false;
		List<Booking> bookings = bookingService.loadEntireTable();
		for(Booking booking : bookings){
			addRow(booking);
		}
	}
	
	/**
	 * <p>destroy.</p>
	 */
	public void destroy(){
		this.ready = false;
		DefaultTableModel tableModel = ((DefaultTableModel)this.getModel());
		for(int i = tableModel.getRowCount()-1; i >=0 ; i--){
			try{
				tableModel.removeRow(i);
			}catch(Exception e){ 
				// fuck it
			}
		}
//		((DefaultTableModel)this.getModel()).setRowCount(0);
	}
	
	/** {@inheritDoc} */
	@Override
	public void onRowChange(Booking entity) {
//		bookingService.update(entity);
	}
	/** {@inheritDoc} */
	@Override
	public void onRowRemove(Booking entity) {
//		bookingService.delete(entity);
	}
	
	/** {@inheritDoc} */
	@Override
	public void onRowAdd(Booking entity) {
//		bookingService.save(entity);
	}
	
	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
	
	/** {@inheritDoc} */
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
