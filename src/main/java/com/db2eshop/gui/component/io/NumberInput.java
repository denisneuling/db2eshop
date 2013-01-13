package com.db2eshop.gui.component.io;

import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

public class NumberInput extends LabeledInput<Integer> {
	private static final long serialVersionUID = -6723222187600862538L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField("");

	public NumberInput() {
		setLayout(new MigLayout("wrap 2", "[right][grow,fill]"));

		this.add(label);
		this.add(jTextField, "growx,push");
	}

	@Override
	public Integer getValue() {
		String text = jTextField.getText();
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException nfe) {
			jTextField.setText(0 + "");
			throw new RuntimeException(nfe);
		}
	}

	@Override
	public void setValue(Object object) {
		if (object != null) {
			if (object instanceof Integer) {
				jTextField.setText(((Integer) object).toString());
			} else {
				log.error("Could not set value of type " + object.getClass());
			}
		}
	}

	@Override
	public void setEditable(boolean editable) {
		jTextField.setEditable(false);
	}

}
