package com.db2eshop.gui.component.table;

import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericTable extends AbstractTableModel implements InitializingBean{
	private static final long serialVersionUID = 1180747329897017816L;

	private volatile String tableName;
	
	public String getTableName(){
		return tableName;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// Todo bindings
	}

}
