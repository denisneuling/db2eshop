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
package com.db2eshop.gui.dialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * <p>Abstract ConfirmCancelDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public abstract class ConfirmCancelDialog extends BaseDialog{
	private static final long serialVersionUID = 8516091888456072697L;
	protected Logger log = Logger.getLogger(this.getClass());

	private MigLayout layout;
	
	private volatile boolean ready = false;
	protected JPanel contentPane;
	private JScrollPane scrollPane;
	
	protected JButton confirmButton;
	protected JButton cancelButton;
	
	/**
	 * <p>Constructor for ConfirmCancelDialog.</p>
	 */
	public ConfirmCancelDialog(){
		layout = new MigLayout("fill","","[grow]rel[grow]");
		
		this.setMinimumSize(new Dimension(600, 300));
		setLayout(layout);
		
		contentPane = new JPanel();
		contentPane.setLayout(new MigLayout("fill"));
		
		scrollPane = new JScrollPane(contentPane);
		add(scrollPane, "grow, push,wrap");
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new MigLayout("fill"));
		
		confirmButton = new JButton("Confirm");
		buttonPane.add(confirmButton, "span,split 2,growx,push");
		confirmButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		buttonPane.add(cancelButton,"growx, push");
		cancelButton.addActionListener(this);
		
		add(buttonPane, "growx");//, south");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		pack();
		
		ready = true;
	}
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(confirmButton.equals(e.getSource())){
			try{
				onConfirm();
				this.setVisible(false);
			}catch(Exception exception){
				onError(exception);
			}
		}else if(cancelButton.equals(e.getSource())){
			try{
				onCancel();
				this.setVisible(false);
			}catch(Exception exception){
				onError(exception);
			}
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public Container getContentPane() {
		if(ready){
			return contentPane;
		}else{
			return super.getContentPane();
		}
	}
	
	/**
	 * <p>onConfirm.</p>
	 */
	public abstract void onConfirm();
	
	/**
	 * <p>onCancel.</p>
	 */
	public abstract void onCancel();
	
	/**
	 * <p>onError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public abstract void onError(Throwable throwable);
}
