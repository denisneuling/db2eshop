package com.db2eshop.gui.component.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Sale;
import com.db2eshop.persistence.SaleDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(Sale.class)
public class SaleTable  extends GenericTable<Sale>{
	private static final long serialVersionUID = 7185437413082164521L;

	@Autowired
	private SaleDao saleDao;

	@Override
	protected AbstractDao<Sale> getDao() {
		return saleDao;
	}
}
