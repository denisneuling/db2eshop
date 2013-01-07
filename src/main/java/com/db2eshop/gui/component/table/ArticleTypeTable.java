package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.ArticleType;

@Component
@UIComponent(ArticleType.class)
public class ArticleTypeTable  extends GenericTable{
	private static final long serialVersionUID = -4692122196698482686L;

}
