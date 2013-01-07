package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Customer;

@Component
@UIComponent(Customer.class)
public class CustomerTable extends GenericTable{
	private static final long serialVersionUID = 8583486834871539743L;

}
