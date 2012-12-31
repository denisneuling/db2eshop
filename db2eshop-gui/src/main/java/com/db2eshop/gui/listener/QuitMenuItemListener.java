package com.db2eshop.gui.listener;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;

@Component
public class QuitMenuItemListener  extends BaseMenuItemListener {

	@Autowired
	private MainFrame mainFrame;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setVisible(false);
		mainFrame.dispose();
		
		// seems to be bit buggy if we call this from an embedded window...
		mainFrame.die();
	}
}
