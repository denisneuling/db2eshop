/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * 
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
