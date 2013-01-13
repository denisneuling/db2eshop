package com.db2eshop.gui.component.tab;

import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.listener.BaseMouseListener;
import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.tab.menu.TabRightClickPopupMenu;
import com.db2eshop.gui.component.table.SaleTable;
import com.db2eshop.gui.component.table.api.GenericTable;

/**
 * <p>SaleTab class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class SaleTab extends AbstractEntityTab{
	private static final long serialVersionUID = -2793893291288956799L;
	
	@Autowired
	private SaleTable saleTable;
	
	@Autowired
	private TabRightClickPopupMenu tabRightClickPopupMenu;
	
	private JScrollPane scrollPane;

	/** {@inheritDoc} */
	@Override
	public String getTableName() {
		return saleTable.getTableName();
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		scrollPane = new JScrollPane(saleTable);
		registerMouseListener(scrollPane, saleTable);
		this.add(scrollPane, "grow, push");
	}
	
	/**
	 * <p>registerMouseListener.</p>
	 *
	 * @param jScrollPane a {@link javax.swing.JScrollPane} object.
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 */
	public void registerMouseListener(JScrollPane jScrollPane, GenericTable<?> table){
		jScrollPane.addMouseListener(new BaseMouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON3) {
					tabRightClickPopupMenu.showMenu(arg0.getPoint(), null, null, saleTable);
				}
			}
		});
	}
}
