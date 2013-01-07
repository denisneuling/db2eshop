package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.SupplierService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Supplier;

@Component
@UIFor(Supplier.class)
public class SupplierTable extends GenericTable<Supplier> {
	private static final long serialVersionUID = 536253715241280006L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SupplierService supplierService;

	@Override
	public void onApplicationReady() {
		List<Supplier> suppliers = supplierService.loadEntireTable();
		for(Supplier supplier : suppliers){
			addRow(supplier);
		}
	}

	@Override
	public void onRowChange(Supplier entity) {
		supplierService.update(entity);		
	}
}
