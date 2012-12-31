package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.table.LieferantenTable;

@Component
public class LieferantenTab extends AbstractEntityTab{
	private static final long serialVersionUID = 4475158981271375654L;

	@Autowired
	private LieferantenTable lieferantenTable;

	@Override
	public String getTableName() {
		return lieferantenTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(lieferantenTable), "grow, push");
	}
}