package com.db2eshop.gui.component.tab.api;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
/**
 * <p>Abstract AbstractEntityTab class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public abstract class AbstractEntityTab extends JPanel implements InitializingBean{
	private static final long serialVersionUID = -538333795587495921L;

	/**
	 * <p>Constructor for AbstractEntityTab.</p>
	 */
	public AbstractEntityTab(){
		setLayout(new MigLayout());
	}
	
	/**
	 * <p>getTableName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public abstract String getTableName();
}
