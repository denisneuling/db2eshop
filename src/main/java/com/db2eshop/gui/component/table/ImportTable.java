package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.ImportService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Import;

@Component
@UIFor(Import.class)
public class ImportTable extends GenericTable<Import>{
	private static final long serialVersionUID = -1146391679064557712L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ImportService importService;

	@Override
	public void onApplicationReady() {
		List<Import> imports = importService.loadEntireTable();
		for(Import singleImport : imports){
			addRow(singleImport);
		}
	}

	@Override
	public void onRowChange(Import entity) {
		importService.update(entity);
	}
}