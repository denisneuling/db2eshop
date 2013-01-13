package com.db2eshop.gui.component.table.model;

import javax.swing.table.DefaultTableModel;

import com.db2eshop.model.support.AbstractModel;

/**
 * <p>EntityTableModel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class EntityTableModel<T extends AbstractModel<T>> extends DefaultTableModel{
	private static final long serialVersionUID = -958940428450132022L;

	private AbstractModel<T> entity;
	/**
	 * <p>Constructor for EntityTableModel.</p>
	 *
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 */
	public EntityTableModel(AbstractModel<T> entity){
		this.entity = entity;
	}
}
