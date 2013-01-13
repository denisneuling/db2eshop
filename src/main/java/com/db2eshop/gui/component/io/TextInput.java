package com.db2eshop.gui.component.io;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

/**
 * <p>TextInput class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class TextInput extends LabeledInput<String> {
	private static final long serialVersionUID = 7628321355750318743L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField();

	/**
	 * <p>Constructor for TextInput.</p>
	 */
	public TextInput() {
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));
		jTextField.setMinimumSize(new Dimension(inputWidth, 10));
		jTextField.setBorder(BorderFactory.createEmptyBorder());
		this.add(label);
		this.add(jTextField, "growx,push");
	}

	/** {@inheritDoc} */
	@Override
	public String getValue() {
		String text = jTextField.getText();
		return text;
	}

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
	@Override
	public void setEditable(boolean editable) {
		jTextField.setEditable(false);
	}

}
