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
package com.db2eshop.gui.component;

import javax.swing.JTabbedPane;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.ArticleTab;
import com.db2eshop.gui.component.tab.ArticleTypeTab;
import com.db2eshop.gui.component.tab.CustomerTab;
import com.db2eshop.gui.component.tab.EmployeeTab;
import com.db2eshop.gui.component.tab.ImportTab;
import com.db2eshop.gui.component.tab.SaleTab;
import com.db2eshop.gui.component.tab.ShippingTab;
import com.db2eshop.gui.component.tab.SupplierTab;

/**
 * <p>EntityTabbedPane class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class EntityTabbedPane extends JTabbedPane implements InitializingBean {
	private static final long serialVersionUID = -5249754982931738042L;

	@Autowired
	private ArticleTab articleTab;
	
	@Autowired
	private ArticleTypeTab articleTypeTab;

	@Autowired
	private CustomerTab customerTab;
	
	@Autowired
	private EmployeeTab employeeTab;
	
	@Autowired
	private ImportTab importTab;
	
	@Autowired
	private SaleTab saleTab;
	
	@Autowired
	private ShippingTab shippingTab;
	
	@Autowired
	private SupplierTab supplierTab;

	/**
	 * <p>Constructor for EntityTabbedPane.</p>
	 */
	public EntityTabbedPane() {
		super(JTabbedPane.LEFT);
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		addTab(articleTab.getTableName(), articleTab);
		addTab(articleTypeTab.getTableName(), articleTypeTab);
		addTab(customerTab.getTableName(), customerTab);
		addTab(employeeTab.getTableName(), employeeTab);
		addTab(importTab.getTableName(), importTab);
		addTab(saleTab.getTableName(), saleTab);
		addTab(shippingTab.getTableName(), shippingTab);
		addTab(supplierTab.getTableName(), supplierTab);
		this.setVisible(true);
	}
}
