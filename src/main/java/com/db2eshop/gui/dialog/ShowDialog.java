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
public class ShowDialog extends ConfirmDialog implements InitializingBean {
	private static final long serialVersionUID = -2281946458815013162L;

	@Autowired
	private UIBinder uiBinder;

	@Value("${gui.dialog.show.title}")
	private String title;

	private transient AbstractModel<?> model;

	public void showDialog(int row, GenericTable<?> table, AbstractModel<?> model) {
		this.model = model;

		buildEditor();
		setVisible(true);
	}

	private void buildEditor() {
		this.getContentPane().removeAll();
		Container container = this.getContentPane();
		container.setLayout(new MigLayout("filly"));
		Map<String, LabeledInput<?>> components = uiBinder.create(model);
		for (LabeledInput<?> labeledInput : components.values()) {
			labeledInput.setEditable(false);
			container.add(labeledInput, "wrap");
		}
		
		this.repaint();
	}

	@Override
	public void onConfirm() {
		model = null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}

}