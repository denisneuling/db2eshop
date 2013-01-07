package com.db2eshop.gui.component.table.cell;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import org.apache.log4j.Logger;

import com.db2eshop.model.support.AbstractModel;

public class EntityTableCellEditor<T extends AbstractModel<T>> extends DefaultCellEditor implements CellEditorListener {
	private static final long serialVersionUID = 4609080583827519706L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	public EntityTableCellEditor(JCheckBox jComponent) {
		super(jComponent);
		log.info("Initialized onto "+jComponent.getClass());
	}

	public EntityTableCellEditor(JComboBox jComponent) {
		super(jComponent);
		log.info("Initialized onto "+jComponent.getClass());
	}

	public EntityTableCellEditor(JTextField jComponent) {
		super(jComponent);
		log.info("Initialized onto "+jComponent.getClass());
	}


	@Override
	public void editingCanceled(ChangeEvent e) {
		log.info(e.getSource().getClass() + " - " + e.getSource());

	}

	@Override
	public void editingStopped(ChangeEvent e) {
		log.info(e.getSource().getClass() + " - " + e.getSource());
	}

}
