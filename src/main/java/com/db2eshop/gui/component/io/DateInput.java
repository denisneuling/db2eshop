package com.db2eshop.gui.component.io;

import java.util.Calendar;
import java.util.Date;

import net.miginfocom.swing.MigLayout;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import org.apache.log4j.Logger;

public class DateInput extends LabeledInput<Date>{
	private static final long serialVersionUID = 2680814138439027839L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JDatePickerImpl jDatePicker;
	
	public DateInput(){
		setLayout(new MigLayout("wrap 2", "[right][grow,fill]"));
		
		this.add(label);
		jDatePicker = new JDatePickerImpl((JDatePanelImpl) JDateComponentFactory.createJDatePanel());
		this.add(jDatePicker,"growx,push");
	}

	@Override
	public Date getValue() {
		DateModel<?> dateModel = jDatePicker.getModel();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, dateModel.getYear());
		calendar.set(Calendar.MONTH, dateModel.getMonth());
		calendar.set(Calendar.DAY_OF_MONTH, dateModel.getDay());
		
		return calendar.getTime();
	}

	@Override
	@SuppressWarnings("deprecation")
	public void setValue(Object object) {
		if(object!=null){
			if (object instanceof Date) {
				Date currentDate = (Date)object;
				jDatePicker.getModel().setYear(currentDate.getYear());
				jDatePicker.getModel().setMonth(currentDate.getMonth());
				jDatePicker.getModel().setDay(currentDate.getDay());
			} else{
				log.error("Could not set value of type " + object.getClass());
			}
		}
	}

	@Override
	public void setEditable(boolean editable) {
	}

}
