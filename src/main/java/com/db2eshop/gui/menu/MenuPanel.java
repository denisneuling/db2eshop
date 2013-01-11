package com.db2eshop.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;
import com.db2eshop.gui.listener.QuitMenuItemListener;
import com.db2eshop.gui.listener.SettingsMenuItemListener;

@Component
/**
 * <p>MenuPanel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class MenuPanel extends JMenuBar implements InitializingBean {
	private static final long serialVersionUID = -8033351688374778735L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private SettingsMenuItemListener settingsMenuItemListener;
	
	@Autowired
	private QuitMenuItemListener quitMenuItemListener;
	
	private JMenu jMenu;
	private JMenuItem quitItem;
	private JMenuItem settingsItem;
	
	/**
	 * <p>Constructor for MenuPanel.</p>
	 */
	public MenuPanel(){
	}	
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.removeAll();
		
		jMenu = new JMenu("File");
		
		settingsItem =  new JMenuItem("Settings");
		settingsItem.addActionListener(settingsMenuItemListener);
		quitItem = new JMenuItem("Exit");
		quitItem.addActionListener(quitMenuItemListener);
		
		jMenu.add(settingsItem);
		jMenu.add(new JSeparator());
		jMenu.add(quitItem);
		this.add(jMenu);
		
		this.setVisible(true);
	}
	
	/**
	 * <p>disableItems.</p>
	 */
	public void disableItems(){
	}
	
	/**
	 * <p>enableItems.</p>
	 */
	public void enableItems(){
	}
}
