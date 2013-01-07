package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.ImportTable;

@Component
public class ImportTab extends AbstractEntityTab{
	private static final long serialVersionUID = -4813755540750285937L;
	
	@Autowired
	private ImportTable importTable;

	@Override
	public String getTableName() {
		return importTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(importTable), "grow, push");
	}
}