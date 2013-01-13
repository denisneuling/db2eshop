package com.db2eshop.gui.component.io;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

import com.db2eshop.gui.component.io.listener.FillUpJListMouseListener;
import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.persistence.support.AbstractDao;

/**
 * <p>EmbeddedEntityInput class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class EmbeddedEntityInput extends LabeledInput<AbstractModel<?>> {
	private static final long serialVersionUID = -3059177943483630930L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	private JList jList;
	
	private AbstractDao<?> dao;
	/**
	 * <p>Constructor for EmbeddedEntityInput.</p>
	 *
	 * @param dao a {@link com.db2eshop.persistence.support.AbstractDao} object.
	 */
	public EmbeddedEntityInput(AbstractDao<?> dao){
		this.dao = dao;
		
		jList = new JList();
		jList.setModel(new DefaultListModel());
		jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jList.addMouseListener(new FillUpJListMouseListener(this));
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));
		
		this.add(label);
		this.add(jList);
//		,"growx,push");
		
		jList.setVisible(true);
	}

	/** {@inheritDoc} */
	@Override
	public AbstractModel<?> getValue() {
		return (AbstractModel<?>) jList.getSelectedValue();
	}

	/** {@inheritDoc} */
	@Override
	public void setValue(Object object) {
		if(object!=null){
			log.debug("Setting value of type " + object.getClass());
			if (object instanceof AbstractModel) {
				jTextField.setText((object).toString());
			} else if(object instanceof Long){
				AbstractModel<?> valueToSet = dao.findById((Long)object);
				((DefaultListModel)jList.getModel()).addElement(valueToSet);
				jList.setSelectedIndex(jList.getModel().getSize()-1);
			}else{
				log.error("Could not set value of type " + object.getClass());
			}
		}
	}

	/** {@inheritDoc} */
	@Override
	public void setEditable(boolean editable) {
		jList.setEnabled(editable);
		
	}
	
	private JTextField jTextField = new JTextField("");
	
	/**
	 * <p>updateList.</p>
	 */
	public void updateList() {
		List<?> entities = dao.findAll();
		AbstractModel<?> selectedOne = getValue();
		if(selectedOne!=null){
			entities.remove(selectedOne);
		}
		for(Object whatever : entities){
			((DefaultListModel)jList.getModel()).addElement(whatever);
		}
	}
}



































