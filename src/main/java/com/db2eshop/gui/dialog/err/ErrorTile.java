package com.db2eshop.gui.dialog.err;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * <p>ErrorTile class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ErrorTile extends JPanel {
	private static final long serialVersionUID = 5721008799327440736L;

	private JLabel label = new JLabel();
	private JLabel content = new JLabel();

	private String message;
	private Throwable throwable;

	/**
	 * <p>Constructor for ErrorTile.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 */
	public ErrorTile(String message) {
		this.message = message;

		buildTile();
	}

	/**
	 * <p>Constructor for ErrorTile.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public ErrorTile(String message, Throwable throwable) {
		this.message = message;
		this.throwable = throwable;

		buildTile();
	}

	/**
	 * <p>Constructor for ErrorTile.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public ErrorTile(Throwable throwable) {
		this.throwable = throwable;

		buildTile();
	}

	/**
	 * <p>buildTile.</p>
	 */
	public void buildTile() {
		this.setLayout(new MigLayout());

		label.setFont(new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize()));
		if (message != null && !message.isEmpty()) {
			label.setText(message);
			this.add(label, "wrap");
		} else if (throwable != null) {
			label.setText(throwable.getMessage());
			this.add(label, "wrap");
		}

		if (throwable != null) {
			content.setText(getStackTraceAsString(throwable));
			this.add(content, "gapleft 30");
		}

		this.repaint();
		this.setVisible(true);
	}

	private String getStackTraceAsString(Throwable exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body>");
		for (StackTraceElement element : throwable.getStackTrace()) {
			sb.append(element.toString());
			sb.append("<br>");
		}
		sb.append("</body></html>");
		return sb.toString();

		// Writer result = new StringWriter();
		// PrintWriter printWriter = new PrintWriter(result);
		// exception.printStackTrace(printWriter);
		// return result.toString();
	}
}
