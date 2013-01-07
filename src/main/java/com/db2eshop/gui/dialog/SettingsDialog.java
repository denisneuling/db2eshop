package com.db2eshop.gui.dialog;

import java.awt.Container;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.governance.service.gui.SettingsService;

@Component
public class SettingsDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = -8952902211592950640L;

	@Value("${gui.dialog.settings.title}")
	private String title;
	
	@Autowired
	private SettingsService settingsService;
	
	@Override
	public void onConfirm() {
		
	}

	@Override
	public void onCancel() {
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.setTitle(title);
		
		Container contentPane = this.getContentPane();
	}

}
