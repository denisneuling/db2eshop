package com.db2eshop.gui.component.io;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

/**
 * <p>DoubleInput class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class DoubleInput extends LabeledInput<Double> {
	private static final long serialVersionUID = -315477593380755590L;

	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField(30);

	/**
	 * <p>Constructor for DoubleInput.</p>
	 */
	public DoubleInput() {
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));

		jTextField.setMinimumSize(new Dimension(inputWidth, 10));
		jTextField.setBorder(BorderFactory.createEmptyBorder());
		this.add(label);
		this.add(jTextField, "growx,push");
	}

	/** {@inheritDoc} */
	@Override
	public Double getValue() {
		String text = jTextField.getText();
		try {
			return Double.parseDouble(text);
		} catch (NumberFormatException nfe) {
			throw new RuntimeException(label.getText() +": Input must be a number.");
		}
	}

	/** {@inheritDoc} */
	@Override
	public void setValue(Object object) {
		if (object != null) {
			if(object instanceof Double) {
				jTextField.setText(((Double) object).toString());
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
