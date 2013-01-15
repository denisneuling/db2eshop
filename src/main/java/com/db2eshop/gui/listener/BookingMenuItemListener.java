package com.db2eshop.gui.listener;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;
import com.db2eshop.gui.dialog.BookingDialog;

@Component
public class BookingMenuItemListener extends BaseMenuItemListener {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private BookingDialog bookingDialog;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		log.debug(e);
		
		bookingDialog.setVisible(true);
	}
}