package com.db2eshop.gui.component.table.listener;

import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.listener.BaseMouseListener;

@Component
public class TableMenuCapableMouseListener extends BaseMouseListener{

//	@Autowired
//	private TablePopupMenu tablePopupMenu;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		log.debug("Mouse clicked: " + arg0);

		if (arg0.getButton() == MouseEvent.BUTTON3) {
//			tablePopupMenu.relocate(arg0.getPoint());
//			tablePopupMenu.setVisible(true);
		}
	}

}
