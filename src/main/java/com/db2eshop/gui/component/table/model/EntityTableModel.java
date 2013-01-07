package com.db2eshop.gui.component.table.model;

import javax.swing.table.DefaultTableModel;

import com.db2eshop.model.support.AbstractModel;

public class EntityTableModel<T extends AbstractModel<T>> extends DefaultTableModel{
	private static final long serialVersionUID = -958940428450132022L;

	private AbstractModel<T> entity;
	public EntityTableModel(AbstractModel<T> entity){
		this.entity = entity;
	}
}
