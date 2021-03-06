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
package com.db2eshop.gui.component.io;

import java.util.Calendar;
import java.util.Date;

import net.miginfocom.swing.MigLayout;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import org.apache.log4j.Logger;

import com.db2eshop.util.DateUtil;

/**
 * <p>DateInput class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class DateForm extends LabeledForm<Date>{
	private static final long serialVersionUID = 2680814138439027839L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JDatePickerImpl jDatePicker;
	
	/**
	 * <p>Constructor for DateInput.</p>
	 */
	public DateForm(){
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));
		
		this.add(label);
		jDatePicker = new JDatePickerImpl((JDatePanelImpl) JDateComponentFactory.createJDatePanel());
		this.add(jDatePicker,"growx,push");
	}

	/** {@inheritDoc} */
	@Override
	public Date getValue() {
		DateModel<?> dateModel = jDatePicker.getModel();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, dateModel.getYear());
		calendar.set(Calendar.MONTH, dateModel.getMonth());
		calendar.set(Calendar.DAY_OF_MONTH, dateModel.getDay());
		
		return calendar.getTime();
	}

	/** {@inheritDoc} */
	@Override
	public void setValue(Object object) {
		if(object!=null){
			if (object instanceof Date) {
				Date currentDate = (Date)object;
				setDate(currentDate);
			} else if(object instanceof String){
				Date currentDate = DateUtil.asDate((String)object);
				setDate(currentDate);
			}else{
				log.error("Could not set value of type " + object.getClass());
			}
		}
	}
	
	private void setDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		jDatePicker.getModel().setYear(calendar.get(Calendar.YEAR));
		jDatePicker.getModel().setMonth(calendar.get(Calendar.MONTH));
		jDatePicker.getModel().setDay(calendar.get(Calendar.DAY_OF_MONTH));
		jDatePicker.updateUI();
	}

	/** {@inheritDoc} */
	@Override
	public void setEditable(boolean editable) {
	}

}
