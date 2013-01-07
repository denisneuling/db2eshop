package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.CustomerService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Customer;

@Component
@UIFor(Customer.class)
public class CustomerTable extends GenericTable<Customer>{
	private static final long serialVersionUID = 8583486834871539743L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;

	@Override
	public void onApplicationReady() {
		List<Customer> customers = customerService.loadEntireTable();
		for(Customer customer : customers){
			addRow(customer);
		}
	}

	@Override
	public void onRowChange(Customer entity) {
		customerService.update(entity);
	}

}
