package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Supplier;

@Component
@UIComponent(Supplier.class)
public class SupplierTable  extends GenericTable{
	private static final long serialVersionUID = 536253715241280006L;

}
