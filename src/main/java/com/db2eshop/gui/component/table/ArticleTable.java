package com.db2eshop.gui.component.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Article;
import com.db2eshop.persistence.ArticleDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(Article.class)
public class ArticleTable extends GenericTable<Article>{
	private static final long serialVersionUID = 5044674525159404880L;

	@Autowired
	private ArticleDao articleDao;

	@Override
	protected AbstractDao<Article> getDao() {
		return articleDao;
	}
}
