package com.db2eshop.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class BaseMenuItemListener implements ActionListener {
	protected Logger log = Logger.getLogger(this.getClass());

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("Action performed: " + e.toString());
	}
}
