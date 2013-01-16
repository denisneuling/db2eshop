package com.db2eshop.gui.dialog;

import java.awt.Container;

import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.err.orm.ConstraintVialotionTranslator;
import com.db2eshop.gui.component.table.TurnoverTable;

@Component
/**
 * <p>TurnoverDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class TurnoverDialog extends ConfirmDialog implements InitializingBean{
	private static final long serialVersionUID = 2216192343543999120L;
	
	@Value("${gui.dialog.turnover.title}")
	private String title;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	@Autowired
	private TurnoverTable turnoverTable;
	
	@Autowired
	private ConstraintVialotionTranslator constraintVialotionTranslator;
	
	private JScrollPane scrollPane;
	
	/** {@inheritDoc} */
	@Override
	protected final void postShow(){
		turnoverTable.setup();
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		turnoverTable.destroy();
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setTitle(title);
		
		this.getContentPane().removeAll();
		Container container = this.getContentPane();
		container.setLayout(new MigLayout("fill"));
		scrollPane = new JScrollPane(turnoverTable);
		container.add(scrollPane, "grow, push");
	}

	/**
	 * <p>onConstraintViolation.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String onConstraintViolation(Throwable throwable){
		return constraintVialotionTranslator.translate(throwable);
	}
}
