package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.CustomerTable;

@Component
public class CustomerTab extends AbstractEntityTab{
	private static final long serialVersionUID = 2188335294379153415L;
	
	@Autowired
	private CustomerTable customerTable;

	@Override
	public String getTableName() {
		return customerTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(customerTable), "grow, push");
	}
}