package com.db2eshop.gui.dialog;

import java.awt.Container;
import java.util.Map;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.governance.UIBinder;
import com.db2eshop.gui.component.io.LabeledInput;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.support.AbstractModel;

@Component
/**
 * <p>EditDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
@SuppressWarnings("unused")
public class EditDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = -2281946458815013162L;

	@Value("${gui.dialog.edit.title}")
	private String title;
	
	@Autowired
	private UIBinder uiBinder;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	private volatile GenericTable<?> table;
	private volatile Integer row;
	private volatile AbstractModel<?> model;
	private volatile Map<String, LabeledInput<?>> components;
	
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
		for (LabeledInput<?> labeledInput : components.values()) {
			container.add(labeledInput, "wrap");
		}
		
		this.repaint();
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

}
