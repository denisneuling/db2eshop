package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Shipping;

@Component
@UIComponent(Shipping.class)
public class ShippingTable extends GenericTable{
	private static final long serialVersionUID = 6298771983478946691L;

}
