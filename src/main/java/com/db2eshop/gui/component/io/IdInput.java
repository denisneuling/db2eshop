package com.db2eshop.gui.component.io;

import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

public class IdInput extends LabeledInput<Long> {
	private static final long serialVersionUID = -8517052445051136182L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField("-1");

	public IdInput() {
		setEditable(false);
		setLayout(new MigLayout("wrap 2", "[right][grow,fill]"));

		this.add(label);
		this.add(jTextField, "growx,push");
	}

	@Override
	public Long getValue() {
		String text = jTextField.getText();
		try {
			return Long.parseLong(text);
		} catch (NumberFormatException nfe) {
			jTextField.setText(0 + "");
			throw new RuntimeException(nfe);
		}
	}

	@Override
	public void setValue(Object object) {
		if (object != null) {
			if (object instanceof Long) {
				jTextField.setText(((Long) object).toString());
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
