package com.db2eshop.gui.component.tab;

import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.listener.BaseMouseListener;
import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.ImportTable;
import com.db2eshop.gui.component.table.api.GenericTable;

@Component
/**
 * <p>ImportTab class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class ImportTab extends AbstractEntityTab{
	private static final long serialVersionUID = -4813755540750285937L;
	
	@Autowired
	private ImportTable importTable;
	
	private JScrollPane scrollPane;

	/** {@inheritDoc} */
	@Override
	public String getTableName() {
		return importTable.getTableName();
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		scrollPane = new JScrollPane(importTable);
		registerMouseListener(scrollPane, importTable);
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
//					table
				}
			}
		});
	}
}
