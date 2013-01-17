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
package com.db2eshop.gui.dialog.err;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import com.db2eshop.gui.component.io.common.CollapsablePanel;

/**
 * <p>ErrorTile class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ErrorTile extends JPanel {
	private static final long serialVersionUID = 5721008799327440736L;

	private final String INDENT = "        ";
	private JLabel label = new JLabel();
	private JLabel content = new JLabel();

	private String message;
	private Throwable throwable;
	
	private JComponent parent;

	/**
	 * <p>Constructor for ErrorTile.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param parent a {@link javax.swing.JComponent} object.
	 */
	public ErrorTile(String message, JComponent parent) {
		this.message = message;
		this.parent = parent;

		buildTile();
	}

	/**
	 * <p>Constructor for ErrorTile.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param throwable a {@link java.lang.Throwable} object.
	 * @param parent a {@link javax.swing.JComponent} object.
	 */
	public ErrorTile(String message, Throwable throwable, JComponent parent) {
		this.message = message;
		this.throwable = throwable;
		this.parent = parent;

		buildTile();
	}

	/**
	 * <p>Constructor for ErrorTile.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 * @param parent a {@link javax.swing.JComponent} object.
	 */
	public ErrorTile(Throwable throwable, JComponent parent) {
		this.throwable = throwable;
		this.parent = parent;

		buildTile();
	}

	/**
	 * <p>buildTile.</p>
	 */
	public void buildTile() {
		this.setLayout(new MigLayout());

		// TODO find way to make line break automatic...
		label.setFont(new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize()));
		if (message != null && !message.isEmpty()) {
			label.setText("<html><body>"+message+"</body></html>");
			this.add(label, "wrap");
		} else if (throwable != null) {
			label.setText("<html><body>"+throwable.getMessage()+"</body></html>");
			this.add(label, "wrap");
		}

		if (throwable != null) {
			CollapsablePanel collapsablePanel = new CollapsablePanel(true);
			collapsablePanel.setCollapseMessage("Hide StackTrace");
			collapsablePanel.setUnCollapseMessage("Show StackTrace");
			collapsablePanel.setParent(parent);
			content.setText(getFullStackTraceAsString(throwable));
			collapsablePanel.setHiddenPane(content);
			this.add(collapsablePanel, "gapleft 30");
		}

		this.repaint();
		this.setVisible(true);
	}
	
	private String getFullStackTraceAsString(Throwable th){
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body><pre><code>");
		sb.append(getStackTraceAsString(th));
		while(th!=null){
			th = th.getCause();
			if(th != null){
				sb.append("Caused by: ");
				sb.append(getStackTraceAsString(th));
			}
		}
		sb.append("</code></pre></body></html>");
		return sb.toString();
	}
	
	private String getStackTraceAsString(Throwable th) {
		if(th == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(th.getClass().getName());
		sb.append(": ");
		sb.append(th.getMessage());
		sb.append((char)10);
		for (StackTraceElement element : th.getStackTrace()) {
			String el = element.toString();
			sb.append(INDENT+el);
			sb.append((char)10);
		}
		return sb.toString();
	}
}
