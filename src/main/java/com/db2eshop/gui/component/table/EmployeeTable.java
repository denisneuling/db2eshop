package com.db2eshop.gui.component.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Employee;
import com.db2eshop.persistence.EmployeeDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(Employee.class)
public class EmployeeTable  extends GenericTable<Employee>{
	private static final long serialVersionUID = -1896093636084399376L;

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	protected AbstractDao<Employee> getDao() {
		return employeeDao;
	}
}
