package com.db2eshop.gui.component.table;

import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIComponent;
import com.db2eshop.models.Artikel;

@Component
@UIComponent(Artikel.class)
public class ArtikelTable extends GenericTable{
	private static final long serialVersionUID = 3015004378690951786L;

}
