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

import java.awt.event.MouseEvent;

import com.db2eshop.gui.component.listener.BaseMouseListener;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.support.AbstractModel;

/**
 * <p>
 * TableMenuCapableMouseListener class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class TableMenuCapableMouseListener extends BaseMouseListener {

	private RightClickPopupMenu rightClickPopupMenu;
	private GenericTable<?> genericTable;

	/**
	 * <p>Constructor for TableMenuCapableMouseListener.</p>
	 *
	 * @param genericTable a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 * @param clickPopupMenu a {@link com.db2eshop.gui.menu.RightClickPopupMenu} object.
	 */
	public TableMenuCapableMouseListener(GenericTable<?> genericTable, RightClickPopupMenu clickPopupMenu) {
		this.genericTable = genericTable;
		this.rightClickPopupMenu = clickPopupMenu;
	}

	/** {@inheritDoc} */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		log.debug("Mouse clicked: " + arg0);

		if (genericTable == null || rightClickPopupMenu == null) {
			throw new RuntimeException("Targeted table could not been found.");
		}

		if (arg0.getButton() == MouseEvent.BUTTON3) {
			int row = genericTable.rowAtPoint(arg0.getPoint());
			genericTable.getSelectionModel().setSelectionInterval(row, row);
			AbstractModel<?> entity = genericTable.getEntityAtRow(row);
			rightClickPopupMenu.showMenu(arg0.getPoint(), row, entity, genericTable);
		}
	}

}
