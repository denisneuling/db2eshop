package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.EmployeeService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.dialog.ErrorDialog;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.Employee;

/**
 * <p>EmployeeTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
@UIFor(Employee.class)
public class EmployeeTable  extends GenericTable<Employee>{
	private static final long serialVersionUID = -1896093636084399376L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	protected TableMenuCapableMouseListener tableMenuCapableMouseListener;

	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		List<Employee> employees = employeeService.loadEntireTable();
		for(Employee employee : employees){
			addRow(employee);
		}
		
		tableMenuCapableMouseListener = new TableMenuCapableMouseListener(this, rightClickPopupMenu);
		this.addMouseListener(tableMenuCapableMouseListener);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowChange(Employee entity) {
		employeeService.update(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowRemove(Employee entity) {
		employeeService.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowAdd(Employee entity) {
		employeeService.save(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(throwable);
	}
}
