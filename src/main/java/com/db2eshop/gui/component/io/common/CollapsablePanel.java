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
package com.db2eshop.gui.component.io.common;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

/**
 * <p>CollapsablePanel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class CollapsablePanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = -8792031162123258336L;
	protected Logger log = Logger.getLogger(this.getClass());

	private String collapseMessage = "Collapse";
	private String unCollapseMessage = "Uncollapse";

	private boolean collapsed = true;

	private JComponent parent;
	
	private JLabel jLabel;
	private JPanel contentPane;
	
	private Component hiddenPane;

	/**
	 * <p>Constructor for CollapsablePanel.</p>
	 */
	public CollapsablePanel() {
		buildPane();
	}

	/**
	 * <p>Constructor for CollapsablePanel.</p>
	 *
	 * @param collapsed a boolean.
	 */
	public CollapsablePanel(boolean collapsed) {
		this.collapsed = collapsed;

		buildPane();
	}
	
	private void buildPane(){
		this.setLayout(new MigLayout("fill"));
		
		this.jLabel = new JLabel(this.collapsed ? "<html><body>&or; <a href=\"#\">" + this.unCollapseMessage + "</a></body></html>" : "<html><body>&and; <a href=\"#\">" + this.collapseMessage + "</a></body></html>");
		this.jLabel.addMouseListener(this);
		
		this.contentPane = new JPanel(new MigLayout("fill"));
		this.contentPane.setVisible(true);
		
		this.add(jLabel, "wrap");
		this.add(contentPane);
	}

	/**
	 * <p>Getter for the field <code>hiddenPane</code>.</p>
	 *
	 * @return a {@link java.awt.Component} object.
	 */
	public Component getHiddenPane() {
		return hiddenPane;
	}

	/**
	 * <p>Setter for the field <code>hiddenPane</code>.</p>
	 *
	 * @param hiddenPane a {@link java.awt.Component} object.
	 */
	public void setHiddenPane(Component hiddenPane) {
		this.hiddenPane = hiddenPane;
	}

	/**
	 * <p>Getter for the field <code>collapseMessage</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCollapseMessage() {
		return this.collapseMessage;
	}

	/**
	 * <p>Setter for the field <code>collapseMessage</code>.</p>
	 *
	 * @param collapseMessage a {@link java.lang.String} object.
	 */
	public void setCollapseMessage(String collapseMessage) {
		this.collapseMessage = collapseMessage;
		this.jLabel.setText(this.collapsed ? "<html><body>&or; <a href=\"#\">" + this.unCollapseMessage + "</a></body></html>" : "<html><body>&and; <a href=\"#\">" + this.collapseMessage + "</a></body></html>");
	}

	/**
	 * <p>Getter for the field <code>unCollapseMessage</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUnCollapseMessage() {
		return unCollapseMessage;
	}

	/**
	 * <p>Setter for the field <code>unCollapseMessage</code>.</p>
	 *
	 * @param unCollapseMessage a {@link java.lang.String} object.
	 */
	public void setUnCollapseMessage(String unCollapseMessage) {
		this.unCollapseMessage = unCollapseMessage;
		this.jLabel.setText(this.collapsed ? "<html><body>&or; <a href=\"#\">" + this.unCollapseMessage + "</a></body></html>" : "<html><body>&and; <a href=\"#\">" + this.collapseMessage + "</a></body></html>");
	}
	
	/**
	 * <p>isCollapsed.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isCollapsed() {
		return collapsed;
	}
	
	/** {@inheritDoc} */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		log.debug("Mouse clicked: " + arg0);
		this.collapsed = !this.collapsed;
		jLabel.setText(this.collapsed ? "<html><body>&or; <a href=\"#\">" + this.unCollapseMessage + "</a></body></html>" : "<html><body>&and; <a href=\"#\">" + this.collapseMessage + "</a></body></html>");
		if(this.collapsed){
			contentPane.remove(hiddenPane);
		}else{
			contentPane.add(hiddenPane);
		}
		contentPane.updateUI();
		this.updateUI();
		if(parent!=null){
			parent.revalidate();
			parent.updateUI();
		}
	}

	/** {@inheritDoc} */
	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	/** {@inheritDoc} */
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	/** {@inheritDoc} */
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	/** {@inheritDoc} */
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	/**
	 * <p>Setter for the field <code>parent</code>.</p>
	 *
	 * @param parent a {@link javax.swing.JComponent} object.
	 */
	public void setParent(JComponent parent) {
		this.parent = parent;
	}

}
