package com.db2eshop.gui.component.io.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.apache.log4j.Logger;

import com.db2eshop.gui.component.io.EmbeddedEntityInput;
import com.db2eshop.gui.component.listener.BaseMouseListener;

public class FillUpJListMouseListener extends BaseMouseListener implements MouseListener{
	protected Logger log = Logger.getLogger(this.getClass());
	
	private boolean updated = false;
	private EmbeddedEntityInput embeddedEntityInput;
	public FillUpJListMouseListener(EmbeddedEntityInput embeddedEntityInput){
		this.embeddedEntityInput = embeddedEntityInput;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!updated){
			embeddedEntityInput.updateList();
		}
	}
}