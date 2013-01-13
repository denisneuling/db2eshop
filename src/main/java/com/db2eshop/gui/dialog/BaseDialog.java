package com.db2eshop.gui.dialog;

import java.awt.Dimension;
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
