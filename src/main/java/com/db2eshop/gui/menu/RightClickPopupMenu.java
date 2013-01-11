package com.db2eshop.gui.menu;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.MainFrame;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.gui.dialog.AddDialog;
import com.db2eshop.gui.dialog.EditDialog;
import com.db2eshop.gui.dialog.RemoveDialog;
import com.db2eshop.model.support.AbstractModel;

@Component
public class RightClickPopupMenu extends JPopupMenu implements InitializingBean, ActionListener{
	private static final long serialVersionUID = -5478903794243320305L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private AddDialog addDialog;
	
	@Autowired
	private EditDialog editDialog;
	
	@Autowired
	private RemoveDialog removeDialog;
	
	private volatile Integer row;
	private volatile Integer column;
	private volatile AbstractModel<?> entity; 
	private volatile GenericTable<?> table;
	
	private JMenuItem add;
	private JMenuItem edit;
	private JMenuItem remove;
	
	public RightClickPopupMenu(){
		add = new JMenuItem("Add Entity");
		edit = new JMenuItem("Edit Entity");
		remove = new JMenuItem("Remove Entity");
		
		this.add(add);
		this.add(edit);
		this.add(remove);
		
		this.pack();
	}
	
	public <T> void showMenu(Point location, int row, int column, AbstractModel<?> entity, GenericTable<?> table){
		relocate(location);
		this.setVisible(true);
		
		this.row = row;
		this.column = column;
		this.entity = entity;
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(add.equals(arg0.getSource())){
			log.info("Add");
			addDialog.showDialog(table);
		}else if(edit.equals(arg0.getSource())){
			log.debug("Edit");
			editDialog.showDialog(row, table, entity);
		}else if(remove.equals(arg0.getSource())){
			log.debug("Remove");
			removeDialog.showDialog(row, table);
		}
		
		unsetVolatile();
	}
	
	private void unsetVolatile(){
		this.row = null;
		this.column = null;
		this.entity = null;
		this.table = null;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		add.addActionListener(this);
		edit.addActionListener(this);
		remove.addActionListener(this);
		
		setInvoker(mainFrame);
	}
	
	public void relocate(Point point){
		Point mainFrameLocation = mainFrame.getLocation();
		this.setLocation((int)(mainFrameLocation.getX() + point.getX()) + 30, (int)(mainFrameLocation.getY() + point.getY()) + 60);
	}
}