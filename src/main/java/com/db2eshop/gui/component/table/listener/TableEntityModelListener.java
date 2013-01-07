package com.db2eshop.gui.component.table.listener;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.log4j.Logger;

import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.support.AbstractModel;

public class TableEntityModelListener<T extends AbstractModel<T>> implements TableModelListener{
	protected Logger log = Logger.getLogger(getClass()); 

	private GenericTable<T> table;
	public TableEntityModelListener(GenericTable<T> table){
		this.table = table;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		log.debug(table.getClass().getName()+" - row: "+e.getFirstRow());
		table.rowChanged(e.getFirstRow());
	}

}
