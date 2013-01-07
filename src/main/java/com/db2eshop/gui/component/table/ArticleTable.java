package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.Article;

@Component
@UIComponent(Article.class)
public class ArticleTable extends GenericTable{
	private static final long serialVersionUID = 5044674525159404880L;

}
