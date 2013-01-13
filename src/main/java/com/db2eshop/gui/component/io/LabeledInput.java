package com.db2eshop.gui.component.io;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class LabeledInput<T> extends JPanel{
	private static final long serialVersionUID = -6759994950632289431L;

	protected JLabel label = new JLabel();
	
	public abstract T getValue();
	
	public abstract void setValue(Object object);
	
	public abstract void setEditable(boolean editable);
	
	public void setLabel(String label){
		this.label.setText(label);
	}
}
