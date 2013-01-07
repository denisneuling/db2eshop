package com.db2eshop.gui.component;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashBoard extends JPanel implements InitializingBean {
	private static final long serialVersionUID = 6816890195017278060L;

	@Autowired
	private EntityTabbedPane entityTabbedPane;
	
	public DashBoard() {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setLayout(new MigLayout("fill"));
		add(entityTabbedPane, "grow, push");
		
		this.repaint();
		this.setVisible(true);
	}

}