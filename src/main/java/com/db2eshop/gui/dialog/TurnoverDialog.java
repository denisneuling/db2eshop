package com.db2eshop.gui.dialog;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.err.orm.ConstraintVialotionTranslator;
import com.db2eshop.governance.service.model.TurnoverService;

@Component
public class TurnoverDialog extends ConfirmDialog implements InitializingBean{
	private static final long serialVersionUID = 2216192343543999120L;
	
	@Value("${gui.dialog.turnover.title}")
	private String title;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	@Autowired
	private TurnoverService turnoverService;
	
	@Autowired
	private ConstraintVialotionTranslator constraintVialotionTranslator;
	
	@Override
	public void onConfirm() {
		// nothing
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setTitle(title);		
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
