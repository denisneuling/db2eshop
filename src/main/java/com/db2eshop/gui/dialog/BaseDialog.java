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
package com.db2eshop.gui.dialog;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;

/**
 * <p>Abstract BaseDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public abstract class BaseDialog extends JDialog implements WindowListener, ActionListener{
	protected Logger log = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 2323710041837666035L;

	@Autowired
	protected MainFrame mainFrame;
	
	/**
	 * <p>relocate.</p>
	 */
	public void relocate(){
		log.debug("Relocation.");
		
		Point location = mainFrame.getLocation();
		Point newLocation = new Point((int)location.getX()+40,(int)location.getY()+40);
		this.setLocation(newLocation);
	}
	
	/** {@inheritDoc} */
	@Override
	public void setVisible(boolean visible){
		if(visible){
			relocate();
		}
		super.setVisible(visible);
		if(visible){
			postShow();
		}
	}
	
	/**
	 * <p>postShow.</p>
	 */
	protected void postShow(){
		// anything to do?
	}
	
	/** {@inheritDoc} */
	@Override
	public void windowActivated(WindowEvent e) {
		log.debug("Window activated.");
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosed(WindowEvent e) {
		log.debug("Window closed.");
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosing(WindowEvent e) {
		log.debug("Window closing.");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeactivated(WindowEvent e) {
		log.debug("Window deactivated.");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeiconified(WindowEvent e) {
		log.debug("Window deiconified.");
	}

	/** {@inheritDoc} */
	@Override
	public void windowIconified(WindowEvent e) {
		log.debug("Window iconified.");
	}

	/** {@inheritDoc} */
	@Override
	public void windowOpened(WindowEvent e) {
		log.debug("Window opened.");
	}
}
