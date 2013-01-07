package com.db2eshop.gui.component.tab;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.table.ArticleTypeTable;

@Component
public class ArticleTypeTab extends AbstractEntityTab{
	private static final long serialVersionUID = -7898974718627948366L;
	
	@Autowired
	private ArticleTypeTable articleTypeTable;

	@Override
	public String getTableName() {
		return articleTypeTable.getTableName();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.add(new JScrollPane(articleTypeTable), "grow, push");
	}
}