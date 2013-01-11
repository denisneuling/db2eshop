package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.ImportService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.Import;

@Component
/**
 * <p>ImportTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@UIFor(Import.class)
public class ImportTable extends GenericTable<Import>{
	private static final long serialVersionUID = -1146391679064557712L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ImportService importService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;

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

	@Override
	public void onRowRemove(Import entity) {
		importService.delete(entity);
	}

	@Override
	public void onRowAdd(Import entity) {
		importService.save(entity);
	}
}
