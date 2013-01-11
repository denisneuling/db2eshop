package com.db2eshop.gui.component.tab;

import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.listener.BaseMouseListener;
import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.SupplierTable;
import com.db2eshop.gui.component.table.api.GenericTable;

@Component
/**
 * <p>SupplierTab class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class SupplierTab extends AbstractEntityTab{
	private static final long serialVersionUID = 4475158981271375654L;

	@Autowired
	private SupplierTable supplierTable;
	
	private JScrollPane scrollPane;

	/** {@inheritDoc} */
	@Override
	public String getTableName() {
		return supplierTable.getTableName();
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		scrollPane = new JScrollPane(supplierTable);
		registerMouseListener(scrollPane, supplierTable);
		this.add(scrollPane, "grow, push");
	}
	
	public void registerMouseListener(JScrollPane jScrollPane, GenericTable<?> table){
		jScrollPane.addMouseListener(new BaseMouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON3) {
//					table
				}
			}
		});
	}
}
