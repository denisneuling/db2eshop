package com.db2eshop.gui.component.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Shipping;
import com.db2eshop.persistence.ShippingDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(Shipping.class)
public class ShippingTable extends GenericTable<Shipping>{
	private static final long serialVersionUID = 6298771983478946691L;

	@Autowired
	private ShippingDao shippingDao;

	@Override
	protected AbstractDao<Shipping> getDao() {
		return shippingDao;
	}
}
