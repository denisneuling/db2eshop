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
import com.db2eshop.util.orm.TableValueEntityResolver;

/**
 * <p>EditDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class EditDialog extends ORMActionDialog implements InitializingBean{
	private static final long serialVersionUID = -2281946458815013162L;

	@Value("${gui.dialog.edit.title}")
	private String title;
	
	@Autowired
	private UIBinder uiBinder;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	@Autowired
	private TableValueEntityResolver tableValueEntityResolver;
	
	private volatile GenericTable<?> table;
	private volatile Integer row;
	private volatile AbstractModel<?> model;
	private volatile Map<String, LabeledForm<?>> components;
	
	/**
	 * <p>Constructor for EditDialog.</p>
	 */
	public EditDialog(){
	}
	
	/**
	 * <p>showDialog.</p>
	 *
	 * @param row a int.
	 * @param table a {@link com.db2eshop.gui.component.table.api.GenericTable} object.
	 * @param model a {@link com.db2eshop.model.support.AbstractModel} object.
	 */
	public void showDialog(int row, GenericTable<?> table, AbstractModel<?> model){
		this.row = row;
		this.table = table;
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
		container.setLayout(new MigLayout("fill"));
		components = uiBinder.create(model);
		
		/*
		 * TODO
		 * find workaround, this is a ugly hack
		 */
//		for (LabeledInput<?> labeledInput : components.values()) {
//			if(labeledInput instanceof EmbeddedEntityInput){
//				((EmbeddedEntityInput)labeledInput).getHashedJListEntries().put(Null.getInstance().toString(), Null.getInstance());
//				JList jList = ((EmbeddedEntityInput)labeledInput).getjList();
//				((DefaultListModel)jList.getModel()).addElement(Null.getInstance());
//			}
//		}
		
		for (LabeledForm<?> labeledInput : components.values()) {
			container.add(labeledInput, "wrap");
		}
		
		this.repaint();
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		for(String property : components.keySet()){
			LabeledForm<?> labeledInput = components.get(property);
			Object currentValue = labeledInput.getValue();
			model = tableValueEntityResolver.setValue(property, currentValue, model);
		}
		table.rowChanged(row, model);
		unsetVolatile();
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		unsetVolatile();
	}
	
	private void unsetVolatile(){
		table = null;
		model = null;
		components = null;
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}

}
