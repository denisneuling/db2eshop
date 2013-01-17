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
package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.SupplierService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.dialog.ErrorDialog;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.Supplier;

/**
 * <p>SupplierTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
@UIFor(Supplier.class)
public class SupplierTable extends GenericTable<Supplier> {
	private static final long serialVersionUID = 536253715241280006L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	protected TableMenuCapableMouseListener tableMenuCapableMouseListener;

	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		List<Supplier> suppliers = supplierService.loadEntireTable();
		for(Supplier supplier : suppliers){
			addRow(supplier);
		}
		
		tableMenuCapableMouseListener = new TableMenuCapableMouseListener(this, rightClickPopupMenu);
		this.addMouseListener(tableMenuCapableMouseListener);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowChange(Supplier entity) {
		supplierService.update(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void onRowRemove(Supplier entity) {
		supplierService.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowAdd(Supplier entity) {
		supplierService.save(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
}
