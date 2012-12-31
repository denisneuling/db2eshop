package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.models.Lieferanten;

@Component
@UIComponent(Lieferanten.class)
public class LieferantenTable extends GenericTable{
	private static final long serialVersionUID = -5302592822317928744L;

}
