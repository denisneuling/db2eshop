package com.db2eshop.gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
	
	private volatile LinkedList<Object> errors = new LinkedList<Object>();

	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		getContentPane().removeAll();
	}

	private JPanel jPanelBottom;
	private JPanel jPanelCenter;
	private JPanel jPanelTop;
	private JScrollPane jScrollPaneErrorMsg;
	private JTextPane jTextPaneErrorMsg;
	private JScrollPane jScrollPaneException;
	private JTextArea jTextAreaException;

	/**
	 * <p>notifyError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */

	private String getStackTraceAsString(Throwable exception) {
		Writer result = new StringWriter();
		PrintWriter printWriter = new PrintWriter(result);
		exception.printStackTrace(printWriter);
		return result.toString();
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
		if (!this.isVisible()) {
			this.setVisible(true);
		}
	}
	
	/**
	 * <p>showError.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public void showError(String message, Throwable throwable){
		log.error(message, throwable);
		if (!this.isVisible()) {
			this.setVisible(true);
		}

		jPanelTop = new JPanel();
		jPanelTop.setLayout(null);
		jPanelTop.setPreferredSize(new Dimension(480, 100));

		jTextPaneErrorMsg = new JTextPane();
		jTextPaneErrorMsg.setFont(jTextPaneErrorMsg.getFont().deriveFont(jTextPaneErrorMsg.getFont().getStyle() | Font.BOLD, jTextPaneErrorMsg.getFont().getSize() + 1));
		jTextPaneErrorMsg.setBorder(null);
		jTextPaneErrorMsg.setEditable(false);
		jTextPaneErrorMsg.setBackground(null);
		jScrollPaneErrorMsg = new JScrollPane(jTextPaneErrorMsg);
		jScrollPaneErrorMsg.setBorder(null);
		jScrollPaneErrorMsg.setSize(new Dimension(405, 80));
		jScrollPaneErrorMsg.setLocation(new Point(71, 13));
		jPanelTop.add(jScrollPaneErrorMsg);

		jPanelCenter = new JPanel();
		jPanelCenter.setSize(new Dimension(420, 300));
		jTextAreaException = new JTextArea();
		jScrollPaneException = new JScrollPane(jTextAreaException);
		jScrollPaneException.setPreferredSize(new Dimension(470, 300));
		jPanelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		jPanelCenter.add(jScrollPaneException);

		jPanelBottom = new JPanel();
		jPanelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jPanelTop, BorderLayout.NORTH);
		this.getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		this.getContentPane().add(jPanelBottom, BorderLayout.SOUTH);

		this.jPanelCenter.setVisible(false);

		if (throwable != null) {
			String exceptionText = getStackTraceAsString(throwable);
			jTextAreaException.setText(exceptionText);
			jTextAreaException.setEditable(false);
		}
	}
	
	/**
	 * <p>showError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public void showError(Throwable throwable){
		log.error(throwable);
		if (!this.isVisible()) {
			this.setVisible(true);
		}

		jPanelTop = new JPanel();
		jPanelTop.setLayout(null);
		jPanelTop.setPreferredSize(new Dimension(480, 100));

		jTextPaneErrorMsg = new JTextPane();
		jTextPaneErrorMsg.setFont(jTextPaneErrorMsg.getFont().deriveFont(jTextPaneErrorMsg.getFont().getStyle() | Font.BOLD, jTextPaneErrorMsg.getFont().getSize() + 1));
		jTextPaneErrorMsg.setBorder(null);
		jTextPaneErrorMsg.setEditable(false);
		jTextPaneErrorMsg.setBackground(null);
		jScrollPaneErrorMsg = new JScrollPane(jTextPaneErrorMsg);
		jScrollPaneErrorMsg.setBorder(null);
		jScrollPaneErrorMsg.setSize(new Dimension(405, 80));
		jScrollPaneErrorMsg.setLocation(new Point(71, 13));
		jPanelTop.add(jScrollPaneErrorMsg);

		jPanelCenter = new JPanel();
		jPanelCenter.setSize(new Dimension(420, 300));
		jTextAreaException = new JTextArea();
		jScrollPaneException = new JScrollPane(jTextAreaException);
		jScrollPaneException.setPreferredSize(new Dimension(470, 300));
		jPanelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		jPanelCenter.add(jScrollPaneException);

		jPanelBottom = new JPanel();
		jPanelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jPanelTop, BorderLayout.NORTH);
		this.getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		this.getContentPane().add(jPanelBottom, BorderLayout.SOUTH);

		this.jPanelCenter.setVisible(false);

		if (throwable != null) {
			String exceptionText = getStackTraceAsString(throwable);
			jTextAreaException.setText(exceptionText);
			jTextAreaException.setEditable(false);
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
	}
}
