package com.db2eshop.gui.component.tab;

import javax.swing.JTabbedPane;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityTabbedPane extends JTabbedPane implements InitializingBean{
	private static final long serialVersionUID = -5249754982931738042L;

	@Autowired
	private ArtikelTab artikelTable;
	
	@Autowired
	private LieferantenTab lieferantenTab;
	
	public EntityTabbedPane(){
		addTab(artikelTable.getTableName(),artikelTable);
		addTab(lieferantenTab.getTableName(), lieferantenTab);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.setVisible(true);
	}
}
