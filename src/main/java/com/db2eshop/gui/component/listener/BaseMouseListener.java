package com.db2eshop.gui.component.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.apache.log4j.Logger;

public abstract class BaseMouseListener implements MouseListener {
	protected Logger log = Logger.getLogger(this.getClass());

	@Override
	public void mouseClicked(MouseEvent arg0) {
		log.debug("Mouse clicked: " + arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		log.debug("Mouse pressed: " + arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		log.debug("Mouse released: " + arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		log.debug("Mouse entered: " + arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		log.debug("Mouse exited: " + arg0);
	}

}
