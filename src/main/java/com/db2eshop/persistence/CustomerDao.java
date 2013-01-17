/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Customer;
import com.db2eshop.persistence.support.AbstractDao;

/**
 * <p>CustomerDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Repository
public class CustomerDao extends AbstractDao<Customer> {

	/**
	 * <p>Constructor for CustomerDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public CustomerDao(SessionFactory sessionFactory) {
		super(sessionFactory, Customer.class);
	}
}
