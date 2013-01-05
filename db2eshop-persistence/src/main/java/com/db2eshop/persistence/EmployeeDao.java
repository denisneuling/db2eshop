package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.models.Employee;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
public class EmployeeDao extends AbstractDao<Employee> {

	@Autowired
	public EmployeeDao(SessionFactory sessionFactory) {
		super(sessionFactory, Employee.class);
	}
}
