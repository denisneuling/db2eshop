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
