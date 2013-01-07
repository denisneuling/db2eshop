package com.db2eshop.gui.component.adapter;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.db2eshop.gui.MainFrame;

public class MainFrameAdapter extends ComponentAdapter {

	private MainFrame mainFrame;

	public MainFrameAdapter(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		mainFrame.repaint();
	}
}
