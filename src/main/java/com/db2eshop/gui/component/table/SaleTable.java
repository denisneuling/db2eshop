package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.SaleService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.Sale;

@Component
/**
 * <p>SaleTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@UIFor(Sale.class)
public class SaleTable  extends GenericTable<Sale>{
	private static final long serialVersionUID = 7185437413082164521L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SaleService saleService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;
	
	protected TableMenuCapableMouseListener tableMenuCapableMouseListener;

	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		List<Sale> sales = saleService.loadEntireTable();
		for(Sale sale : sales ){
			addRow(sale);
		}
		
		tableMenuCapableMouseListener = new TableMenuCapableMouseListener(this, rightClickPopupMenu);
		this.addMouseListener(tableMenuCapableMouseListener);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowChange(Sale entity) {
		saleService.update(entity);
	}

	@Override
	public void onRowRemove(Sale entity) {
		saleService.delete(entity);
	}

	@Override
	public void onRowAdd(Sale entity) {
		saleService.save(entity);
	}
}
