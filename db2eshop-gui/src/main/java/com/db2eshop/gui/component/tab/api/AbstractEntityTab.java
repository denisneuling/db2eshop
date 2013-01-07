package com.db2eshop.gui.component.tab.api;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractEntityTab extends JPanel implements InitializingBean{
	private static final long serialVersionUID = -538333795587495921L;

	public AbstractEntityTab(){
		setLayout(new MigLayout());
	}
	
	public abstract String getTableName();
}
