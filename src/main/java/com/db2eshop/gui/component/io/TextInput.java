package com.db2eshop.gui.component.io;

import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

public class TextInput extends LabeledInput<String> {
	private static final long serialVersionUID = 7628321355750318743L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField("");

	public TextInput() {
		setLayout(new MigLayout("wrap 2", "[right][grow,fill]"));

		this.add(label);
		this.add(jTextField, "growx,push");
	}

	@Override
	public String getValue() {
		String text = jTextField.getText();
		return text;
	}

	@Override
	public void setValue(Object object) {
		if (object != null) {
			if (object instanceof String) {
				jTextField.setText((object).toString());
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
