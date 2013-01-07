package com.db2eshop.gui.component.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Supplier;
import com.db2eshop.persistence.SupplierDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(Supplier.class)
public class SupplierTable  extends GenericTable<Supplier>{
	private static final long serialVersionUID = 536253715241280006L;

	@Autowired
	private SupplierDao supplierDao;

	@Override
	protected AbstractDao<Supplier> getDao() {
		return supplierDao;
	}
}
