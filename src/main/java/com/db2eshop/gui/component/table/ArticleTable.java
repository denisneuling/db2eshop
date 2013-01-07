package com.db2eshop.gui.component.table;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.ArticleService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Article;

@Component
@UIFor(Article.class)
public class ArticleTable extends GenericTable<Article>{
	private static final long serialVersionUID = 5044674525159404880L;

	@Autowired
	private ArticleService articleService;
	
	@Override
	public void onApplicationReady() {
		List<Article> articles = articleService.loadEntireTable();
		for(Article article : articles){
			addRow(article);
		}
	}

	@Override
	public void onRowChange(Article entity) {
		articleService.update(entity);
	}
}
