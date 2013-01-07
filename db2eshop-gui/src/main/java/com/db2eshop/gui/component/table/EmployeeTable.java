package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Employee;

@Component
@UIComponent(Employee.class)
public class EmployeeTable  extends GenericTable{
	private static final long serialVersionUID = -1896093636084399376L;

}
