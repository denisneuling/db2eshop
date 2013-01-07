package com.db2eshop.gui.component.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Import;
import com.db2eshop.persistence.ImportDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(Import.class)
public class ImportTable extends GenericTable<Import>{
	private static final long serialVersionUID = -1146391679064557712L;

	@Autowired
	private ImportDao importDao;

	@Override
	protected AbstractDao<Import> getDao() {
		return importDao;
	}

}
