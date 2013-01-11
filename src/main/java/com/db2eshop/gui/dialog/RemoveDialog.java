package com.db2eshop.gui.dialog;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.table.api.GenericTable;

@Component
public class RemoveDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = -8846282721759634756L;

	@Value("${gui.dialog.remove.title}")
	private String title;
	
	private volatile GenericTable<?> table;
	private volatile Integer row;
	
	public void showDialog(int row, GenericTable<?> table){
		this.row = row;
		this.table = table;
		setVisible(true);
	}
	
	@Override
	public void onConfirm() {
		table.removeRow(row);
		table = null;
	}

	@Override
	public void onCancel() {
		table = null;
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}
}
