package com.db2eshop.gui.component.tab;

import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractEntityTab extends JPanel{
	private static final long serialVersionUID = -538333795587495921L;

	public abstract String getTableName();
}
