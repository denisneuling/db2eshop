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

/**
 * <p>QuitMenuItemListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class QuitMenuItemListener extends BaseMenuItemListener {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MainFrame mainFrame;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		log.debug(e);
		
		mainFrame.setVisible(false);
		mainFrame.dispose();
		
		// seems to be bit buggy if we call this from an embedded window...
		mainFrame.die();
	}
}
