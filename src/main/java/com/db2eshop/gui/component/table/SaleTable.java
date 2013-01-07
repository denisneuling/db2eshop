package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.SaleService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Sale;

@Component
@UIFor(Sale.class)
public class SaleTable  extends GenericTable<Sale>{
	private static final long serialVersionUID = 7185437413082164521L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SaleService saleService;

	@Override
	public void onApplicationReady() {
		List<Sale> sales = saleService.loadEntireTable();
		for(Sale sale : sales ){
			addRow(sale);
		}
	}

	@Override
	public void onRowChange(Sale entity) {
		saleService.update(entity);
	}
}
