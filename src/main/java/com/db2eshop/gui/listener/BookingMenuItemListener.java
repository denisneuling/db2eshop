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
package com.db2eshop.gui.listener;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;
import com.db2eshop.gui.dialog.BookingDialog;

@Component
/**
 * <p>BookingMenuItemListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
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
