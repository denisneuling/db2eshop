package com.db2eshop.gui.component.adapter;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.db2eshop.gui.MainFrame;

/**
 * <p>MainFrameAdapter class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class MainFrameAdapter extends ComponentAdapter {

	private MainFrame mainFrame;

	/**
	 * <p>Constructor for MainFrameAdapter.</p>
	 *
	 * @param mainFrame a {@link com.db2eshop.gui.MainFrame} object.
	 */
	public MainFrameAdapter(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/** {@inheritDoc} */
	@Override
	public void componentResized(ComponentEvent e) {
		mainFrame.repaint();
	}
}
