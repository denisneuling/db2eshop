package com.db2eshop.gui.component.table.listener;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.log4j.Logger;

import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.support.AbstractModel;

/**
 * <p>TableEntityModelListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class TableEntityModelListener<T extends AbstractModel<T>> implements TableModelListener{
	protected Logger log = Logger.getLogger(getClass()); 

	private GenericTable<T> table;
	/**
	 * <p>Constructor for TableEntityModelListener.</p>
	 *
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 */
	public TableEntityModelListener(GenericTable<T> table){
		this.table = table;
	}
	
	/** {@inheritDoc} */
	@Override
	public void tableChanged(TableModelEvent e) {
		log.debug(table.getClass().getName()+" - row: "+e.getFirstRow());
		table.rowChanged(e.getFirstRow());
	}

}
