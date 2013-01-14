package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.CustomerService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.dialog.ErrorDialog;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.Customer;

/**
 * <p>CustomerTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
@UIFor(Customer.class)
public class CustomerTable extends GenericTable<Customer>{
	private static final long serialVersionUID = 8583486834871539743L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;

	@Autowired
	private ErrorDialog errorDialog;
	
	protected TableMenuCapableMouseListener tableMenuCapableMouseListener;

	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		List<Customer> customers = customerService.loadEntireTable();
		for(Customer customer : customers){
			addRow(customer);
		}
		
		tableMenuCapableMouseListener = new TableMenuCapableMouseListener(this, rightClickPopupMenu);
		this.addMouseListener(tableMenuCapableMouseListener);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowChange(Customer entity) {
		customerService.update(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowRemove(Customer entity) {
		customerService.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowAdd(Customer entity) {
		customerService.save(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
}
