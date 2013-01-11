package com.db2eshop.gui.dialog;

import java.awt.Container;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.governance.UIBinder;
import com.db2eshop.gui.component.table.api.GenericTable;

@Component
public class AddDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = 3423718231846257527L;

	@Value("${gui.dialog.add.title}")
	private String title;
	
	@Autowired
	private UIBinder uiBinder;
	
	private transient GenericTable<?> table;
	
	public void showDialog(GenericTable<?> table){
		this.table = table;
		
		buildEditor();
		setVisible(true);
	}
	
	private void buildEditor(){
		Container container = this.getContentPane();
	}
	
	@Override
	public void onConfirm() {
		// TODO Auto-generated method stub
		
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
