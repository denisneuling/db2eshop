package com.db2eshop.gui.dialog;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * <p>Abstract ConfirmCancelDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public abstract class ConfirmCancelDialog extends BaseDialog{
	private static final long serialVersionUID = 8516091888456072697L;
	protected Logger log = Logger.getLogger(this.getClass());

	private MigLayout layout;
	
	private volatile boolean ready = false;
	protected JPanel contentPane = new JPanel();
	protected JButton confirmButton;
	protected JButton cancelButton;
	
	/**
	 * <p>Constructor for ConfirmCancelDialog.</p>
	 */
	public ConfirmCancelDialog(){
		layout = new MigLayout("fill","","[grow]rel[grow]");
		
		setLayout(layout);
		contentPane = new JPanel();
		contentPane.setLayout(new MigLayout("fill"));
		add(contentPane, "grow,push,wrap");
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new MigLayout("fill"));
		
		confirmButton = new JButton("Confirm");
		buttonPane.add(confirmButton, "span,split 2,growx,push");
		confirmButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		buttonPane.add(cancelButton,"growx, push");
		cancelButton.addActionListener(this);
		
		add(buttonPane, "growx, push");//, south");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		pack();
		
		ready = true;
	}
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(confirmButton.equals(e.getSource())){
			try{
				onConfirm();
				this.setVisible(false);
			}catch(Exception exception){
				onError(exception);
			}
		}else if(cancelButton.equals(e.getSource())){
			try{
				onCancel();
				this.setVisible(false);
			}catch(Exception exception){
				onError(exception);
			}
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public Container getContentPane() {
		if(ready){
			return contentPane;
		}else{
			return super.getContentPane();
		}
	}
	
	/**
	 * <p>onConfirm.</p>
	 */
	public abstract void onConfirm();
	
	/**
	 * <p>onCancel.</p>
	 */
	public abstract void onCancel();
	
	/**
	 * <p>onError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public abstract void onError(Throwable throwable);
}
