package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Customer;
import com.db2eshop.persistence.CustomerDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(Customer.class)
public class CustomerTable extends GenericTable<Customer>{
	private static final long serialVersionUID = 8583486834871539743L;

	private CustomerDao customerDao;

	@Override
	protected AbstractDao<Customer> getDao() {
		return customerDao;
	}
}
