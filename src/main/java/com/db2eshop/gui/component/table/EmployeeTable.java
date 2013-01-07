package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.EmployeeService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Employee;

@Component
@UIFor(Employee.class)
public class EmployeeTable  extends GenericTable<Employee>{
	private static final long serialVersionUID = -1896093636084399376L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public void onApplicationReady() {
		List<Employee> employees = employeeService.loadEntireTable();
		for(Employee employee : employees){
			addRow(employee);
		}
	}

	@Override
	public void onRowChange(Employee entity) {
		employeeService.update(entity);
	}

}
