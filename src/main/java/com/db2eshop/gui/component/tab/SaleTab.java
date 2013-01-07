package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.SaleTable;

@Component
public class SaleTab extends AbstractEntityTab{
	private static final long serialVersionUID = -2793893291288956799L;
	
	@Autowired
	private SaleTable saleTable;

	@Override
	public String getTableName() {
		return saleTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(saleTable), "grow, push");
	}
}