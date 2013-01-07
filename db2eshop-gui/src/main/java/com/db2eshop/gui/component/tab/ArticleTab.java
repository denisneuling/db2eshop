package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.ArticleTable;

@Component
public class ArticleTab extends AbstractEntityTab{
	private static final long serialVersionUID = -7331929490773962158L;
	
	@Autowired
	private ArticleTable articleTable;
	
	@Override
	public String getTableName() {
		return articleTable.getTableName();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(articleTable), "grow, push");
	}
}
