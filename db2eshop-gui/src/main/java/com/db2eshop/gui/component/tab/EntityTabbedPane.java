package com.db2eshop.gui.component.tab;

import javax.swing.JTabbedPane;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityTabbedPane extends JTabbedPane implements InitializingBean {
	private static final long serialVersionUID = -5249754982931738042L;

	@Autowired
	private ArtikelTab artikelTab;

	@Autowired
	private LieferantenTab lieferantenTab;

	public EntityTabbedPane() {
		super(JTabbedPane.LEFT);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		addTab(artikelTab.getTableName(), artikelTab);
		addTab(lieferantenTab.getTableName(), lieferantenTab);
		this.setVisible(true);
	}
}
