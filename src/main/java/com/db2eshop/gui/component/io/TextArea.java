package com.db2eshop.gui.component.io;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

/**
 * <p>TextArea class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class TextArea extends LabeledInput<String> {
	private static final long serialVersionUID = -2609420739863688029L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextArea jTextField = new JTextArea();

	/**
	 * <p>Constructor for TextArea.</p>
	 */
	public TextArea() {
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));

		jTextField.setMaximumSize(new Dimension(inputWidth, 100));
		jTextField.setMinimumSize(new Dimension(inputWidth, 100));
		jTextField.setLineWrap(true);
		jTextField.setWrapStyleWord(true);
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
