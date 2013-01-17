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
package com.db2eshop.gui.component.tab.api;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <p>Abstract AbstractEntityTab class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public abstract class AbstractEntityTab extends JPanel implements InitializingBean{
	private static final long serialVersionUID = -538333795587495921L;

	/**
	 * <p>Constructor for AbstractEntityTab.</p>
	 */
	public AbstractEntityTab(){
		setLayout(new MigLayout());
	}
	
	/**
	 * <p>getTableName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public abstract String getTableName();
}
