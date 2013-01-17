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
package com.db2eshop.gui.component.io.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.apache.log4j.Logger;

import com.db2eshop.gui.component.io.EntityForm;
import com.db2eshop.gui.component.listener.BaseMouseListener;

/**
 * <p>FillUpJListMouseListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class FillUpJListMouseListener extends BaseMouseListener implements MouseListener{
	protected Logger log = Logger.getLogger(this.getClass());
	
	private boolean updated = false;
	private EntityForm embeddedEntityInput;
	/**
	 * <p>Constructor for FillUpJListMouseListener.</p>
	 *
	 * @param embeddedEntityInput a {@link com.db2eshop.gui.component.io.EntityForm} object.
	 */
	public FillUpJListMouseListener(EntityForm embeddedEntityInput){
		this.embeddedEntityInput = embeddedEntityInput;
	}
	
	/** {@inheritDoc} */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!updated){
			embeddedEntityInput.updateList();
			this.updated = true;
		}
	}
}
