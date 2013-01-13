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

/**
 * <p>RemoveDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class RemoveDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = -8846282721759634756L;

	@Autowired
	private UIBinder uiBinder;

	@Value("${gui.dialog.remove.title}")
	private String title;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	private volatile GenericTable<?> table;
	private volatile Integer row;
	private volatile AbstractModel<?> model;
	private volatile Map<String, LabeledInput<?>> components; 
	
	/**
	 * <p>Constructor for RemoveDialog.</p>
	 */
	public RemoveDialog(){
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
		this.table = table;
		this.row = row;

		try{
			buildEditor();
			setVisible(true);
		}catch(Throwable throwable){
			onError(throwable);
		}
	}
	
	/**
	 * <p>buildEditor.</p>
	 */
	public void buildEditor(){
		this.getContentPane().removeAll();
		Container container = this.getContentPane();
		container.setLayout(new MigLayout("filly"));
		components = uiBinder.create(model);
		for (LabeledInput<?> labeledInput : components.values()) {
			labeledInput.setEditable(false);
			container.add(labeledInput, "wrap");
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		table.removeRow(row);
		table = null;
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		table = null;
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
