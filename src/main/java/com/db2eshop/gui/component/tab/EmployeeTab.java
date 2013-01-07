package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.EmployeeTable;

@Component
public class EmployeeTab extends AbstractEntityTab{
	private static final long serialVersionUID = 7009889466212726163L;
	
	@Autowired
	private EmployeeTable employeeTable;

	@Override
	public String getTableName() {
		return employeeTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(employeeTable), "grow, push");
	}
}