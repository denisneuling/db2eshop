package com.db2eshop.gui.dialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * <p>Abstract ConfirmDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public abstract class ConfirmDialog extends BaseDialog{
	private static final long serialVersionUID = 5958464790527032755L;
	protected Logger log = Logger.getLogger(this.getClass());

	private MigLayout layout;
	
	private volatile boolean ready = false;
	protected JPanel contentPane = new JPanel();
	protected JButton confirmButton;
	
	/**
	 * <p>Constructor for ConfirmDialog.</p>
	 */
	public ConfirmDialog(){
		layout = new MigLayout("fill");
		
		setMinimumSize(new Dimension(300, 110));
		
		setLayout(layout);
		contentPane = new JPanel();
		contentPane.setLayout(new MigLayout("fill"));
		add(contentPane, "wrap");
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new MigLayout("fill"));
		
		confirmButton = new JButton("Confirm");
		buttonPane.add(confirmButton, "span, split 2, growx");
		confirmButton.addActionListener(this);
		
		add(buttonPane, "growx, south");
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
	 * <p>onError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public abstract void onError(Throwable throwable);
	
}
