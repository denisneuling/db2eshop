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

import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.err.orm.ConstraintVialotionTranslator;
import com.db2eshop.gui.component.table.BookingTable;

@Component
/**
 * <p>BookingDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class BookingDialog extends ConfirmDialog implements InitializingBean{
	private static final long serialVersionUID = -4531651812678026241L;

	@Value("${gui.dialog.booking.title}")
	private String title;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	@Autowired
	private BookingTable bookingTable;
	
	@Autowired
	private ConstraintVialotionTranslator constraintVialotionTranslator;
	
	private JScrollPane scrollPane;
	
	/** {@inheritDoc} */
	@Override
	protected final void postShow(){
		bookingTable.setup();
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		bookingTable.destroy();
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setTitle(title);
		
		this.getContentPane().removeAll();
		Container container = this.getContentPane();
		container.setLayout(new MigLayout("fill"));
		scrollPane = new JScrollPane(bookingTable);
		container.add(scrollPane, "grow, push");
	}

	/**
	 * <p>onConstraintViolation.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String onConstraintViolation(Throwable throwable){
		return constraintVialotionTranslator.translate(throwable);
	}
}
