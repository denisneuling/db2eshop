package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Sale;

@Component
@UIComponent(Sale.class)
public class SaleTable  extends GenericTable{
	private static final long serialVersionUID = 7185437413082164521L;

}
