package com.db2eshop.gui.component;

import java.awt.Container;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.EntityTabbedPane;

@Component
public class DashBoard extends Container implements InitializingBean {
	private static final long serialVersionUID = 6816890195017278060L;

	@Autowired
	private EntityTabbedPane entityTabbedPane;
	
	public DashBoard() {
		setLayout(new MigLayout("", "[grow]", "[]5[]"));
		setMinimumSize(new Dimension(400,400));
		
		add(entityTabbedPane);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.repaint();
		this.setVisible(true);
	}

}
