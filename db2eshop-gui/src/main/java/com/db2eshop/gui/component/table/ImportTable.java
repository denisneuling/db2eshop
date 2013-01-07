package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Import;

@Component
@UIComponent(Import.class)
public class ImportTable extends GenericTable{
	private static final long serialVersionUID = -1146391679064557712L;

}
