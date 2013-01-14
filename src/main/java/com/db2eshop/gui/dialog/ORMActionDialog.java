package com.db2eshop.gui.dialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.err.orm.ConstraintVialotionTranslator;

@Component
/**
 * <p>Abstract ORMActionDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public abstract class ORMActionDialog extends ConfirmCancelDialog{
	private static final long serialVersionUID = 4389737938092046254L;

	@Autowired
	private ConstraintVialotionTranslator constraintVialotionTranslator;
	
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
