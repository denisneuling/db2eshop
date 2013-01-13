package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.ShippingService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.dialog.ErrorDialog;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.Shipping;

@Component
/**
 * <p>ShippingTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@UIFor(Shipping.class)
public abstract class ShippingTable extends GenericTable<Shipping>{
	private static final long serialVersionUID = 6298771983478946691L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ShippingService shippingService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;

	@Autowired
	private ErrorDialog errorDialog;
	
	protected TableMenuCapableMouseListener tableMenuCapableMouseListener;

	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		List<Shipping> shippings = shippingService.loadEntireTable();
		for(Shipping shipping : shippings){
			addRow(shipping);
		}
		
		tableMenuCapableMouseListener = new TableMenuCapableMouseListener(this, rightClickPopupMenu);
		this.addMouseListener(tableMenuCapableMouseListener);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowChange(Shipping entity) {
		shippingService.update(entity);		
	}

	/** {@inheritDoc} */
	@Override
	public void onRowRemove(Shipping entity) {
		shippingService.delete(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowAdd(Shipping entity) {
		shippingService.save(entity);
	}
	
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(throwable);
	}
}
