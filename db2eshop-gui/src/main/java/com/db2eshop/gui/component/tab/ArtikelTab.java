package com.db2eshop.gui.component.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.table.ArtikelTable;

@Component
public class ArtikelTab extends AbstractEntityTab{
	private static final long serialVersionUID = -138950884776005913L;

	@Autowired
	private ArtikelTable artikelTable;
	
	@Override
	public String getTableName() {
		return artikelTable.getTableName();
	}
}
