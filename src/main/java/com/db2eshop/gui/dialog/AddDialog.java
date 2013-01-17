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
import com.db2eshop.util.ClassUtil;
import com.db2eshop.util.orm.TableValueEntityResolver;

/**
 * <p>AddDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class AddDialog extends ORMActionDialog implements InitializingBean{
	private static final long serialVersionUID = 3423718231846257527L;

	@Value("${gui.dialog.add.title}")
	private String title;
	
	@Autowired
	private UIBinder uiBinder;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	@Autowired
	private TableValueEntityResolver tableValueEntityResolver;
	
	private volatile GenericTable<?> table;
	private volatile Map<String, LabeledForm<?>> components;
	
	/**
	 * <p>Constructor for AddDialog.</p>
	 */
	public AddDialog(){
	}
	
	/**
	 * <p>showDialog.</p>
	 *
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 */
	public void showDialog(GenericTable<?> table){
		this.table = table;
		
		try{
			buildEditor();
			setVisible(true);
		}catch(Throwable throwable){
			onError(throwable);
		}
	}
	
	private void buildEditor(){
		this.getContentPane().removeAll();
		Container container = this.getContentPane();
		container.setLayout(new MigLayout("fill"));
		components = uiBinder.create(table.getEntityClazz());
		for (LabeledForm<?> labeledInput : components.values()) {
			container.add(labeledInput, "wrap");
		}
	}
	
	/** {@inheritDoc} */
	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void onConfirm() {
		AbstractModel entity = ClassUtil.newInstance(table.getEntityClazz());
		for(String property : components.keySet()){
			LabeledForm<?> labeledInput = components.get(property);
			Object currentValue = labeledInput.getValue();
			
			entity = tableValueEntityResolver.setValue(property, currentValue, entity);
		}
		table.addRow((AbstractModel) entity);
		unsetVolatile();
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		unsetVolatile();
	}
	
	private void unsetVolatile(){
		table = null;
		components = null;
	}
	
	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}
}
