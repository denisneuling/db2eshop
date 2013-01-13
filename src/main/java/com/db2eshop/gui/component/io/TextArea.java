package com.db2eshop.gui.component.io;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

/**
 * <p>TextArea class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class TextArea extends LabeledInput<String> {
	private static final long serialVersionUID = -2609420739863688029L;
	protected Logger log = Logger.getLogger(this.getClass());

	private JTextArea jTextField = new JTextArea();

	/**
	 * <p>Constructor for TextArea.</p>
	 */
	public TextArea() {
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));

		jTextField.setBounds(0, 0, 200, 100);
		jTextField.setDocument(new LimitedRowLengthDocument(jTextField, 50));
		jTextField.setBorder(BorderFactory.createEmptyBorder());
		this.add(label);
		this.add(jTextField, "growx,push");
	}

	/** {@inheritDoc} */
	@Override
	public String getValue() {
		String text = jTextField.getText();
		return text;
	}

	/** {@inheritDoc} */
	@Override
	public void setValue(Object object) {
		if (object != null) {
			if (object instanceof String) {
				jTextField.setText((object).toString());
			} else {
				log.error("Could not set value of type " + object.getClass());
			}
		}
	}

	/** {@inheritDoc} */
	@Override
	public void setEditable(boolean editable) {
		jTextField.setEditable(false);
	}
}

class LimitedRowLengthDocument extends DefaultStyledDocument {

	private static final long serialVersionUID = -2059737037274062490L;

    private static final String EOL = "\n";
	
    private int max;
    private JTextArea ta = null;

    /**
     * <p>Constructor for LimitedRowLengthDocument.</p>
     *
     * @param ta a {@link javax.swing.JTextArea} object.
     * @param max a int.
     */
    public LimitedRowLengthDocument(JTextArea ta, int max) {
    	this.ta = ta;
    	this.max = max;
    }

    /** {@inheritDoc} */
    public void insertString(int offs, String str, AttributeSet attribute) throws BadLocationException { 
    	
    	int actRow = ta.getLineOfOffset(offs);
    	int rowBeginn = ta.getLineStartOffset(actRow);
    	int rowEnd = ta.getLineEndOffset(actRow);
      	int referenceValue = 0;
      	
    	if (str.length() > 1) {
    		referenceValue = (rowEnd + str.length()) - rowBeginn;
    	} else {
    		referenceValue = rowEnd - rowBeginn;
    	}
    	
    	if (referenceValue >= max) {
        	if (str.length() > 1) {        		
        		StringBuffer str_buff = new StringBuffer();
        		for (int i=0; i<str.length(); i++) {
        			if (i >= max) {
        				str_buff.append(EOL);
        				str_buff.append(str.charAt(i));
        				str = str.substring(i, str.length());
        				i = 0;
        			} else {
        				str_buff.append(str.charAt(i));
        			}
        		}        		
        		str = str_buff + EOL;
        	} else {
        		str = EOL + str;
        	}    		
    	}    	
    	super.insertString(offs, str, attribute);
    }
}
