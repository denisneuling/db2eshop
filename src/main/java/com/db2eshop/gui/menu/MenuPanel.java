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
package com.db2eshop.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;
import com.db2eshop.gui.listener.BookingMenuItemListener;
import com.db2eshop.gui.listener.QuitMenuItemListener;

/**
 * <p>MenuPanel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class MenuPanel extends JMenuBar implements InitializingBean {
	private static final long serialVersionUID = -8033351688374778735L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private QuitMenuItemListener quitMenuItemListener;
	
	@Autowired
	private BookingMenuItemListener bookingMenuItemListener;
	
	private JMenu jMenuFile;
	private JMenuItem fileQuitItem;
	
	private JMenu jMenuFinances;
	private JMenuItem financesBookingItem;
	
	/**
	 * <p>Constructor for MenuPanel.</p>
	 */
	public MenuPanel(){
	}	
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.removeAll();
		
		jMenuFile = new JMenu("File");
		
		fileQuitItem = new JMenuItem("Exit");
		fileQuitItem.addActionListener(quitMenuItemListener);
		
		jMenuFile.add(fileQuitItem);
		this.add(jMenuFile);
		
		jMenuFinances = new JMenu("Finances");
		
		financesBookingItem = new JMenuItem("Booking");
		financesBookingItem.addActionListener(bookingMenuItemListener);
		jMenuFinances.add(financesBookingItem);
		
		this.add(jMenuFinances);
		
		this.setVisible(true);
	}
	
	/**
	 * <p>disableItems.</p>
	 */
	public void disableItems(){
	}
	
	/**
	 * <p>enableItems.</p>
	 */
	public void enableItems(){
	}
}
