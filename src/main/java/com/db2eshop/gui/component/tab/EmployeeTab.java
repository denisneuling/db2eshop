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
package com.db2eshop.gui.component.tab;

import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.listener.BaseMouseListener;
import com.db2eshop.gui.component.tab.api.AbstractEntityTab;
import com.db2eshop.gui.component.tab.menu.TabRightClickPopupMenu;
import com.db2eshop.gui.component.table.EmployeeTable;
import com.db2eshop.gui.component.table.api.GenericTable;

/**
 * <p>EmployeeTab class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class EmployeeTab extends AbstractEntityTab{
	private static final long serialVersionUID = 7009889466212726163L;
	
	@Autowired
	private EmployeeTable employeeTable;
	
	@Autowired
	private TabRightClickPopupMenu tabRightClickPopupMenu;
	
	private JScrollPane scrollPane;

	/** {@inheritDoc} */
	@Override
	public String getTableName() {
		return employeeTable.getTableName();
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		scrollPane = new JScrollPane(employeeTable);
		registerMouseListener(scrollPane, employeeTable);
		this.add(scrollPane, "grow, push");
	}
	
	/**
	 * <p>registerMouseListener.</p>
	 *
	 * @param jScrollPane a {@link javax.swing.JScrollPane} object.
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 */
	public void registerMouseListener(JScrollPane jScrollPane, GenericTable<?> table){
		jScrollPane.addMouseListener(new BaseMouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON3) {
					tabRightClickPopupMenu.showMenu(arg0.getPoint(), null, null, employeeTable);
				}
			}
		});
	}
}
