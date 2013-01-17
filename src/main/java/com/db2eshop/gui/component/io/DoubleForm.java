/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class DoubleForm extends LabeledForm<Double> {
	private static final long serialVersionUID = -315477593380755590L;

	protected Logger log = Logger.getLogger(this.getClass());

	private JTextField jTextField = new JTextField(30);

	/**
	 * <p>Constructor for DoubleInput.</p>
	 */
	public DoubleForm() {
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
