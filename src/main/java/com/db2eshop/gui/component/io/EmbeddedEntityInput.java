package com.db2eshop.gui.component.io;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
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
	private Map<String, Object> hashedJListEntries = new HashMap<String, Object>();
	
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
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setLayoutOrientation(JList.VERTICAL);
		jList.setVisibleRowCount(-1);
		jList.addMouseListener(new FillUpJListMouseListener(this));
		setLayout(new MigLayout("wrap 2", "[100px!,right][grow,fill]"));
		
		JScrollPane listScroller = new JScrollPane(jList);
		listScroller.setMinimumSize(new Dimension(inputWidth, 200));
		
		this.add(label);
		this.add(listScroller);
		
		jList.setVisible(true);
	}

	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("rawtypes")
	public AbstractModel<?> getValue() {
		int index = jList.getSelectedIndex();
		if(index < 0 ){
			return null;
		}
		Object selectedValue = jList.getModel().getElementAt(index);
		String searchKey;
		if(selectedValue instanceof AbstractModel){
			searchKey = ((AbstractModel)selectedValue).toString();
//		}else if(selectedValue instanceof Null){
//			searchKey = Null.getInstance().toString();
		}else{
			searchKey = (String)selectedValue;
		}
		Object value = hashedJListEntries.get(searchKey);
//		if(value instanceof Null){
//			return null;
//		}
		return (AbstractModel<?>) value;
	}

	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("rawtypes")
	public void setValue(Object object) {
		if(object!=null){
			if (object instanceof AbstractModel) {
				AbstractModel valueToSet = (AbstractModel)object;
				hashedJListEntries.put(valueToSet.toString(), valueToSet);
				((DefaultListModel)jList.getModel()).addElement(valueToSet);
				jList.setSelectedIndex(jList.getModel().getSize()-1);
				jList.updateUI();
			} else if(object instanceof Long){
				AbstractModel<?> valueToSet = dao.findById((Long)object);
				hashedJListEntries.put(valueToSet.toString(), valueToSet);
				((DefaultListModel)jList.getModel()).addElement(valueToSet);
				jList.setSelectedIndex(jList.getModel().getSize()-1);
				jList.updateUI();
			}else{
				log.error("Could not set value of type " + object.getClass());
			}
		}else{
			
		}
	}

	/** {@inheritDoc} */
	@Override
	public void setEditable(boolean editable) {
		jList.setEnabled(editable);
		
	}
	
	/**
	 * <p>updateList.</p>
	 */
	public void updateList() {
		List<?> entities = dao.findAll();
		for(Object whatever : entities){
			hashedJListEntries.put(whatever.toString(), whatever);
		}
		AbstractModel<?> selectedOne = getValue();
		if(selectedOne!=null){
			entities.remove(selectedOne);
		}
		for(Object whatever : entities){
			((DefaultListModel)jList.getModel()).addElement(whatever);
		}
	}

	/**
	 * <p>Getter for the field <code>jList</code>.</p>
	 *
	 * @return a {@link javax.swing.JList} object.
	 */
	public JList getjList() {
		return jList;
	}

	/**
	 * <p>Getter for the field <code>hashedJListEntries</code>.</p>
	 *
	 * @return a {@link java.util.Map} object.
	 */
	public Map<String, Object> getHashedJListEntries() {
		return hashedJListEntries;
	}
}



































