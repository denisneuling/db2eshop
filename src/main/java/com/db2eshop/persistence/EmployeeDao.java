package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Employee;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
/**
 * <p>EmployeeDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class EmployeeDao extends AbstractDao<Employee> {

	/**
	 * <p>Constructor for EmployeeDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public EmployeeDao(SessionFactory sessionFactory) {
		super(sessionFactory, Employee.class);
	}
}
