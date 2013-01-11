package com.db2eshop.gui.dialog;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.support.AbstractModel;

@Component
public class EditDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = -2281946458815013162L;

	@Value("${gui.dialog.edit.title}")
	private String title;
	
	private transient GenericTable<?> table;
	private transient Integer row;
	private transient AbstractModel<?> model;
	
	public void showDialog(int row, GenericTable<?> table, AbstractModel<?> model){
		this.row = row;
		this.table = table;
		this.model = model;
		
		setVisible(true);
	}
	
	@Override
	public void onConfirm() {
		
		
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}

}
