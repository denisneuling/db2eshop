package com.db2eshop.gui.listener;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.dialog.SettingsDialog;

@Component
public class SettingsMenuItemListener extends BaseMenuItemListener {

	@Autowired
	private SettingsDialog settingsDialog;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		settingsDialog.relocate();
		settingsDialog.setVisible(true);
	}
}
