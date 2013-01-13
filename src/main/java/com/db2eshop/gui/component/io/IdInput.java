package com.db2eshop.gui.component.io;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

/**
 * <p>IdInput class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class IdInput extends LabeledInput<Long> {
	private static final long serialVersionUID = -8517052445051136182L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField(30);

	/**
	 * <p>Constructor for IdInput.</p>
	 */
	public IdInput() {
		setEditable(false);
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));

		jTextField.setBorder(BorderFactory.createEmptyBorder());
		this.add(label);
		this.add(jTextField, "growx,push");
	}

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
	@Override
	public void setEditable(boolean editable) {
		jTextField.setEditable(false);
	}

}