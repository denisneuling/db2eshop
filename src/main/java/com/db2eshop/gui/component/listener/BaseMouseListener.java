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
package com.db2eshop.gui.component.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.apache.log4j.Logger;

/**
 * <p>Abstract BaseMouseListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public abstract class BaseMouseListener implements MouseListener {
	protected Logger log = Logger.getLogger(this.getClass());

	/** {@inheritDoc} */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		log.debug("Mouse clicked: " + arg0);
	}

	/** {@inheritDoc} */
	@Override
	public void mousePressed(MouseEvent arg0) {
		log.debug("Mouse pressed: " + arg0);
	}

	/** {@inheritDoc} */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		log.debug("Mouse released: " + arg0);
	}

	/** {@inheritDoc} */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		log.debug("Mouse entered: " + arg0);
	}

	/** {@inheritDoc} */
	@Override
	public void mouseExited(MouseEvent arg0) {
		log.debug("Mouse exited: " + arg0);
	}

}
