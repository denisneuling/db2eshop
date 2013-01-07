package com.db2eshop.gui.component.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.models.ArticleType;
import com.db2eshop.persistence.ArticleTypeDao;
import com.db2eshop.persistence.support.AbstractDao;

@Component
@UIFor(ArticleType.class)
public class ArticleTypeTable  extends GenericTable<ArticleType>{
	private static final long serialVersionUID = -4692122196698482686L;

	@Autowired
	private ArticleTypeDao articleTypeDao; 
	
	@Override
	protected AbstractDao<ArticleType> getDao() {
		return articleTypeDao;
	}

}
