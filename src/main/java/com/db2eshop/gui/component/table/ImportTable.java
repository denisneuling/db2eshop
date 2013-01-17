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
import com.db2eshop.governance.service.model.ImportService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.dialog.ErrorDialog;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.Import;

/**
 * <p>ImportTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
@UIFor(Import.class)
public class ImportTable extends GenericTable<Import>{
	private static final long serialVersionUID = -1146391679064557712L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ImportService importService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;

	@Autowired
	private ErrorDialog errorDialog;

	protected TableMenuCapableMouseListener tableMenuCapableMouseListener;
	
	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		List<Import> imports = importService.loadEntireTable();
		for(Import singleImport : imports){
			addRow(singleImport);
		}

		tableMenuCapableMouseListener = new TableMenuCapableMouseListener(this, rightClickPopupMenu);
		this.addMouseListener(tableMenuCapableMouseListener);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowChange(Import entity) {
		importService.update(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowRemove(Import entity) {
		importService.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowAdd(Import entity) {
		importService.save(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
}
