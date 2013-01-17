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
package com.db2eshop.gui.menu;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.dialog.AddDialog;
import com.db2eshop.gui.dialog.EditDialog;
import com.db2eshop.gui.dialog.RemoveDialog;
import com.db2eshop.gui.dialog.ShowDialog;
import com.db2eshop.model.support.AbstractModel;

/**
 * <p>RightClickPopupMenu class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class RightClickPopupMenu extends JPopupMenu implements InitializingBean, ActionListener{
	private static final long serialVersionUID = -5478903794243320305L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private ShowDialog showDialog;
	
	@Autowired
	private AddDialog addDialog;
	
	@Autowired
	private EditDialog editDialog;
	
	@Autowired
	private RemoveDialog removeDialog;
	
	private volatile Integer row;
	private volatile AbstractModel<?> entity; 
	private volatile GenericTable<?> table;
	
	private JMenuItem show;
	private JMenuItem add;
	private JMenuItem edit;
	private JMenuItem remove;
	
	/**
	 * <p>Constructor for RightClickPopupMenu.</p>
	 */
	public RightClickPopupMenu(){
		show = new JMenuItem("Show Entity");
		add = new JMenuItem("Add Entity");
		edit = new JMenuItem("Edit Entity");
		remove = new JMenuItem("Remove Entity");

		this.add(show);
		this.add(new JSeparator());
		this.add(add);
		this.add(edit);
		this.add(remove);
		
		this.pack();
	}
	
	/**
	 * <p>showMenu.</p>
	 *
	 * @param location a {@link java.awt.Point} object.
	 * @param row a int.
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 * @param <T> a T object.
	 */
	public <T> void showMenu(Point location, int row, AbstractModel<?> entity, GenericTable<?> table){
		relocate(location);
		this.setVisible(true);
		
		this.row = row;
		this.entity = entity;
		this.table = table;
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(show.equals(arg0.getSource())){
			log.debug("Show");
			showDialog.showDialog(row, table, entity);
		} 
		
		else if(add.equals(arg0.getSource())){
			log.debug("Add");
			addDialog.showDialog(table);
		}
		
		else if(edit.equals(arg0.getSource())){
			log.debug("Edit");
			editDialog.showDialog(row, table, entity);
		}
		
		else if(remove.equals(arg0.getSource())){
			log.debug("Remove");
			removeDialog.showDialog(row, table, entity);
		}
		
		unsetVolatile();
	}
	
	private void unsetVolatile(){
		this.row = null;
		this.entity = null;
		this.table = null;
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		show.addActionListener(this);
		add.addActionListener(this);
		edit.addActionListener(this);
		remove.addActionListener(this);
		
		setInvoker(mainFrame);
	}
	
	/**
	 * <p>relocate.</p>
	 *
	 * @param point a {@link java.awt.Point} object.
	 */
	public void relocate(Point point){
//		Point mainFrameLocation = mainFrame.getLocation();
		setLocation(MouseInfo.getPointerInfo().getLocation());
//		this.setLocation((int)(mainFrameLocation.getX() + point.getX()) + 40, (int)(mainFrameLocation.getY() + point.getY()) + 70);
	}
}
