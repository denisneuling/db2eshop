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
import java.util.Map;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.governance.UIBinder;
import com.db2eshop.gui.component.io.LabeledForm;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.support.AbstractModel;

/**
 * <p>ShowDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class ShowDialog extends ConfirmDialog implements InitializingBean {
	private static final long serialVersionUID = -2281946458815013162L;

	@Autowired
	private UIBinder uiBinder;

	@Value("${gui.dialog.show.title}")
	private String title;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	private volatile AbstractModel<?> model;
	
	/**
	 * <p>Constructor for ShowDialog.</p>
	 */
	public ShowDialog(){
	}

	/**
	 * <p>showDialog.</p>
	 *
	 * @param row a int.
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 * @param model a {@link com.db2eshop.model.support.AbstractModel} object.
	 */
	public void showDialog(int row, GenericTable<?> table, AbstractModel<?> model) {
		this.model = model;

		try{
			buildEditor();
			setVisible(true);
		}catch(Throwable throwable){
			onError(throwable);
		}
	}

	private void buildEditor() {
		this.getContentPane().removeAll();
		Container container = this.getContentPane();
		container.setLayout(new MigLayout("filly"));
		Map<String, LabeledForm<?>> components = uiBinder.create(model);
		for (LabeledForm<?> labeledInput : components.values()) {
			labeledInput.setEditable(false);
			container.add(labeledInput, "wrap");
		}
		
		this.repaint();
	}

	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		model = null;
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(throwable);
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}
}
