package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.SupplierTable;

@Component
public class SupplierTab extends AbstractEntityTab{
	private static final long serialVersionUID = 4475158981271375654L;

	@Autowired
	private SupplierTable supplierTable;

	@Override
	public String getTableName() {
		return supplierTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(supplierTable), "grow, push");
	}
}
