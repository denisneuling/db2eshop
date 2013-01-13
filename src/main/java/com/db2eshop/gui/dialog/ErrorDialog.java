package com.db2eshop.gui.dialog;

import java.awt.Dimension;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.dialog.err.ErrorTile;

/**
 * <p>ErrorDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class ErrorDialog extends ConfirmDialog implements InitializingBean {
	private static final long serialVersionUID = -1726175077914308091L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Value("${gui.dialog.error.title}")
	private String title;
	
	private JScrollPane scrollPane;
	private JPanel embeddedContentPane = new JPanel();
	
	private volatile LinkedList<ErrorTile> errors = new LinkedList<ErrorTile>();

	/**
	 * <p>Constructor for ErrorDialog.</p>
	 */
	public ErrorDialog(){
		this.setMinimumSize(new Dimension(600, 300));
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		errors.clear();
		embeddedContentPane.removeAll();
	}

	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		showError(throwable);
	}
	
	/**
	 * <p>showError.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 */
	public void showError(String message){
		log.error(message);
		this.showError(message, null);
	}
	
	/**
	 * <p>showError.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public void showError(String message, Throwable throwable){
		log.error(message, throwable);
		
		embeddedContentPane.removeAll();
		embeddedContentPane.setLayout(new MigLayout("fill"));
		
		ErrorTile tile = new ErrorTile(message, throwable);
		errors.add(tile);
		
		Collections.reverse(errors);
		for(ErrorTile errorTile : errors){
			embeddedContentPane.add(errorTile, "wrap");
			embeddedContentPane.updateUI();
		}
		Collections.reverse(errors);
		
		scrollPane.updateUI();
		if (!this.isVisible()) {
			this.setVisible(true);
		}
	}
	
	/**
	 * <p>showError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public void showError(Throwable throwable){
		this.showError(null, throwable);
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
		getContentPane().setLayout(new MigLayout("fill"));
		scrollPane = new JScrollPane(embeddedContentPane);
		getContentPane().add(scrollPane, "grow, push");
	}
}
