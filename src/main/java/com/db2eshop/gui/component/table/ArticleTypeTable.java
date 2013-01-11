package com.db2eshop.gui.component.table;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.ArticleTypeService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.component.table.listener.TableMenuCapableMouseListener;
import com.db2eshop.gui.menu.RightClickPopupMenu;
import com.db2eshop.model.ArticleType;

@Component
/**
 * <p>ArticleTypeTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@UIFor(ArticleType.class)
public class ArticleTypeTable extends GenericTable<ArticleType> {
	private static final long serialVersionUID = -4692122196698482686L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ArticleTypeService articleTypeService;

	@Autowired
	private RightClickPopupMenu rightClickPopupMenu;
	
	protected TableMenuCapableMouseListener tableMenuCapableMouseListener;
	
	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		List<ArticleType> articleTypes = articleTypeService.loadEntireTable();
		for(ArticleType articleType : articleTypes){
			addRow(articleType);
		}
		
		tableMenuCapableMouseListener = new TableMenuCapableMouseListener(this, rightClickPopupMenu);
		this.addMouseListener(tableMenuCapableMouseListener);
	}

	/** {@inheritDoc} */
	@Override
	public void onRowChange(ArticleType entity) {
		articleTypeService.update(entity);
	}

	@Override
	public void onRowRemove(ArticleType entity) {
		articleTypeService.delete(entity);
	}

	@Override
	public void onRowAdd(ArticleType entity) {
		articleTypeService.save(entity);
	}
}
