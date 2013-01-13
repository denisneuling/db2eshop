package com.db2eshop.gui.component.io;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

/**
 * <p>NumberInput class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class NumberInput extends LabeledInput<Integer> {
	private static final long serialVersionUID = -6723222187600862538L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField(20);

	/**
	 * <p>Constructor for NumberInput.</p>
	 */
	public NumberInput() {
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));

		label.setBorder(BorderFactory.createEmptyBorder());
		this.add(label);
		this.add(jTextField, "growx,push");
	}

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
	@Override
	public void setEditable(boolean editable) {
		jTextField.setEditable(false);
	}

}
