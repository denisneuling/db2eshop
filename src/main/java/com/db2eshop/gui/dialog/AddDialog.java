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

/**
 * <p>AddDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class AddDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = 3423718231846257527L;

	@Value("${gui.dialog.add.title}")
	private String title;
	
	@Autowired
	private UIBinder uiBinder;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	private volatile GenericTable<?> table;
	private volatile Map<String, LabeledInput<?>> components;
	
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
		for (LabeledInput<?> labeledInput : components.values()) {
			container.add(labeledInput, "wrap");
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		
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
