package com.db2eshop.gui.dialog;

import java.awt.Container;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.governance.service.gui.SettingsService;

@Component
/**
 * <p>SettingsDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class SettingsDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = -8952902211592950640L;

	@Value("${gui.dialog.settings.title}")
	private String title;
	
	@Autowired
	private SettingsService settingsService;
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setTitle(title);
		
		Container contentPane = this.getContentPane();
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Exception e) {
		// TODO Auto-generated method stub
		
	}

}
