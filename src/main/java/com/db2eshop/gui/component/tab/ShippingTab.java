package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.ShippingTable;

@Component
public class ShippingTab extends AbstractEntityTab{
	private static final long serialVersionUID = -3479416508430189797L;
	
	@Autowired
	private ShippingTable shippingTable;

	@Override
	public String getTableName() {
		return shippingTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(shippingTable), "grow, push");
	}
}