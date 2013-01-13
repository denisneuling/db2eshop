package com.db2eshop.gui.component.tab.menu;

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
import com.db2eshop.model.support.AbstractModel;

/**
 * <p>TabRightClickPopupMenu class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class TabRightClickPopupMenu extends JPopupMenu implements InitializingBean, ActionListener{
	private static final long serialVersionUID = 1351904828139461655L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private AddDialog addDialog;
	
	private volatile GenericTable<?> table;
	
	private JMenuItem add;
	
	/**
	 * <p>Constructor for TabRightClickPopupMenu.</p>
	 */
	public TabRightClickPopupMenu(){
		add = new JMenuItem("Add Entity");

		this.add(add);
		
		this.pack();
	}
	
	/**
	 * <p>showMenu.</p>
	 *
	 * @param location a {@link java.awt.Point} object.
	 * @param row a {@link java.lang.Integer} object.
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 * @param <T> a T object.
	 */
	public <T> void showMenu(Point location, Integer row, AbstractModel<?> entity, GenericTable<?> table){
		relocate(location);
		this.setVisible(true);
		
		this.table = table;
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(add.equals(arg0.getSource())){
			log.info("Add");
			addDialog.showDialog(table);
		}
		unsetVolatile();
	}
	
	private void unsetVolatile(){
		this.table = null;
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		add.addActionListener(this);
		
		setInvoker(mainFrame);
	}
	
	/**
	 * <p>relocate.</p>
	 *
	 * @param point a {@link java.awt.Point} object.
	 */
	public void relocate(Point point){
		Point mainFrameLocation = mainFrame.getLocation();
		this.setLocation((int)(mainFrameLocation.getX() + point.getX()) + 40, (int)(mainFrameLocation.getY() + point.getY()) + 70);
	}
}
