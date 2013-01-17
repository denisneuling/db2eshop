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

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <p>Abstract LabeledInput class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public abstract class LabeledForm<T> extends JPanel{
	private static final long serialVersionUID = -6759994950632289431L;

	protected int inputWidth = 400;
	
	protected JLabel label = new JLabel();
	
	/**
	 * <p>getValue.</p>
	 *
	 * @return a T object.
	 */
	public abstract T getValue();
	
	/**
	 * <p>setValue.</p>
	 *
	 * @param object a {@link java.lang.Object} object.
	 */
	public abstract void setValue(Object object);
	
	/**
	 * <p>setEditable.</p>
	 *
	 * @param editable a boolean.
	 */
	public abstract void setEditable(boolean editable);
	
	/**
	 * <p>Setter for the field <code>label</code>.</p>
	 *
	 * @param label a {@link java.lang.String} object.
	 */
	public void setLabel(String label){
		this.label.setText(label);
	}
}
