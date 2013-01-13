package com.db2eshop.gui.component.table.api;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.db2eshop.exception.NotImplementedException;
import com.db2eshop.gui.component.table.listener.TableEntityModelListener;
import com.db2eshop.gui.dialog.ErrorDialog;
import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.util.ClassUtil;
import com.db2eshop.util.DateUtil;
import com.db2eshop.util.EntityUtil;
import com.db2eshop.util.UIForUtil;
import com.db2eshop.util.ctx.TableValueEntityResolver;

/**
 * <p>Abstract GenericTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public abstract class GenericTable<T extends AbstractModel<T>> extends JTable implements InitializingBean, ApplicationListener<ApplicationEvent> {
	private static final long serialVersionUID = 1180747329897017816L;
	protected Logger log = Logger.getLogger(this.getClass());

	protected Class<T> entityClazz;
	
	protected TableEntityModelListener<T> tableEntityModelListener;
	protected String[] columnNames;
	
	protected volatile String tableName = this.getClass().getSimpleName();
	protected volatile boolean ready = false;
	protected volatile boolean stable = true;
	
	@Autowired
	protected ErrorDialog errorDialog;
	
	@Autowired
	protected TableValueEntityResolver tableValueEntityResolver;

	/**
	 * <p>Getter for the field <code>tableName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * <p>rowChanged.</p>
	 *
	 * @param row a int.
	 */
	@SuppressWarnings("unchecked")
	public void rowChanged(int row) {
		Object[] values = this.getRowAt(row);
		T updateAble = null; 
		if(values[0] == null){
			updateAble = ClassUtil.newInstance(entityClazz);
		}else{
			Long id = (Long) values[0];
			updateAble = (T) tableValueEntityResolver.getDao(entityClazz).findById(id);
		}
		
		try{
			if(stable){
				updateAble = mixin(values, updateAble);
			}
			if (ready) {
				onRowChange(updateAble);
			}
		}catch(Throwable throwable){
			stable = false;
			onError(throwable);
			
			Long id = (Long) values[0];
			updateAble = (T) tableValueEntityResolver.getDao(entityClazz).findById(id);
			rowChanged(row, updateAble);
			stable = true;
		}
	}
	
	/**
	 * <p>rowChanged.</p>
	 *
	 * @param row a int.
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 */
	@SuppressWarnings("unchecked")
	public void rowChanged(int row, AbstractModel<?> entity){
		Object values[] = asTableData((T) entity);
		for(int i = 0 ; i< columnNames.length; i++){
			this.getModel().setValueAt(values[i], row, i);
		}
		if(stable){
			onRowChange((T) entity);
		}
	}

	/**
	 * <p>getRowAt.</p>
	 *
	 * @param row a int.
	 * @return an array of {@link java.lang.Object} objects.
	 */
	public Object[] getRowAt(int row) {
		Object[] result = new Object[columnNames.length];

		for (int column = 0; column < columnNames.length; column++) {
			Object columnValue = this.getModel().getValueAt(row, column);
			result[column] = columnValue;
		}

		return result;
	}
	
	/**
	 * <p>getEntityAtRow.</p>
	 *
	 * @param row a int.
	 * @return a T object.
	 */
	@SuppressWarnings("unchecked")
	public T getEntityAtRow(int row) {
		Object[] values = getRowAt(row);
		T entity = null;
		if(values[0] == null){
			entity = ClassUtil.newInstance(entityClazz);
		}else{
			Long id = (Long) values[0];
			entity = (T) tableValueEntityResolver.getDao(entityClazz).findById(id);
		}
		return mixin(values, entity);
	}

	/**
	 * <p>mixin.</p>
	 *
	 * @param values an array of {@link java.lang.Object} objects.
	 * @param oldEntity a {@link com.db2eshop.model.support.AbstractModel} object.
	 * @return a T object.
	 */
	@SuppressWarnings("unchecked")
	protected T mixin(Object[] values, AbstractModel<T> oldEntity) {
		if (values.length != columnNames.length) {
			throw new RuntimeException("ColumnNames lenght unqual value lenght!");
		}
		if(oldEntity == null){
			log.error("Entity is null. Skip mixing in Properties.");
			return (T) oldEntity;
		}

		for (int i = 0; i < values.length; i++) {
			oldEntity = (AbstractModel<T>) tableValueEntityResolver.setValue(columnNames[i], values[i], oldEntity);
		}

		return (T) oldEntity;
	}

	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		if (!getClass().equals(GenericTable.class)) {
			entityClazz = (Class<T>) UIForUtil.retrieveUIFor(this);
			if (entityClazz != null) {
				tableName = entityClazz.getSimpleName();
				Set<String> metaColumnNames = EntityUtil.getRowMeta(entityClazz).keySet();
				columnNames = metaColumnNames.toArray(new String[metaColumnNames.size()]);
				this.setModel(EntityUtil.asTableModel(entityClazz));
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) this.getModel());
				sorter.setComparator(0, new Comparator<Long>(){
					@Override
					public int compare(Long arg0, Long arg1) {
						if (arg0 == arg1){
							return 0;
						}
						if(arg1>arg0){
							return -1;
						}
						return 1;
					}});
				this.setRowSorter(sorter);
			}
		}
		tableEntityModelListener = new TableEntityModelListener<T>(this);
		this.getModel().addTableModelListener(tableEntityModelListener);
	}
	
	/**
	 * <p>addRow.</p>
	 *
	 * @param entity a T object.
	 */
	@SuppressWarnings("unchecked")
	public void addRow(AbstractModel<T> entity){
		if(ready){
			onRowAdd((T)entity);
		}
		((DefaultTableModel)getModel()).addRow(asTableData((T)entity));
	}
	
	/**
	 * <p>removeRow.</p>
	 *
	 * @param row a int.
	 */
	@SuppressWarnings("unchecked")
	public void removeRow(int row){
		Object[] values = this.getRowAt(row);
		T removeAble = null; 
		if(values[0] == null){
			removeAble = ClassUtil.newInstance(entityClazz);
		}else{
			Long id = (Long) values[0];
			removeAble = (T) tableValueEntityResolver.getDao(entityClazz).findById(id);
		}
		
		try{
			onRowRemove(removeAble);
			((DefaultTableModel)getModel()).removeRow(row);
		}catch(Exception e){
			onError(e);
		}
	}
	/**
	 * <p>removeRow.</p>
	 *
	 * @param entity a T object.
	 */
	public void removeRow(T entity){
		throw new NotImplementedException();
	}

	/**
	 * <p>asTableData.</p>
	 *
	 * @param entity a T object.
	 * @return an array of {@link java.lang.Object} objects.
	 */
	protected Object[] asTableData(T entity) {
		if (entity == null) {
			throw new RuntimeException("Entity cannot be null");
		}
		if (columnNames == null) {
			throw new RuntimeException("Entity extraction fields cannot be null");
		}

		Object[] data = new Object[columnNames.length];
		int index = 0;
		Class<?> entityClass = entity.getClass();
		for (String field : columnNames) {
			try {
				Object object = ClassUtil.getValueOf(field, entity, entityClass, entityClass.getDeclaredField(field).getType());
				if (object != null && AbstractModel.class.isAssignableFrom(object.getClass())) {
					tableValueEntityResolver.asTableData(entity, columnNames);
					object = ((AbstractModel<?>) object).getId();
				} else if(object instanceof Date){
					object = DateUtil.asString((Date)object);
				}
				data[index] = object;
			} catch (Exception e) {
				log.error("Field " + field + " could not been found", e);
				data[index] = e.getMessage();
			}
			index++;
		}
		return data;
	}

	/** {@inheritDoc} */
	@Override
	public final void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			onApplicationReady();
			ready = true;
		}
	}

	/** {@inheritDoc} */
	public boolean isCellEditable(int row, int column) {
		return column != 0;
	}
	
	/**
	 * <p>onApplicationReady.</p>
	 */
	public abstract void onApplicationReady();

	/**
	 * <p>onRowChange.</p>
	 *
	 * @param entity a T object.
	 */
	public abstract void onRowChange(T entity);
	
	/**
	 * <p>onRowRemove.</p>
	 *
	 * @param entity a T object.
	 */
	public abstract void onRowRemove(T entity);
	
	/**
	 * <p>onRowAdd.</p>
	 *
	 * @param entity a T object.
	 */
	public abstract void onRowAdd(T entity);
	
	
	/**
	 * <p>onError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public abstract void onError(Throwable throwable);
	
	/**
	 * <p>Getter for the field <code>entityClazz</code>.</p>
	 *
	 * @return a {@link java.lang.Class} object.
	 */
	public Class<T> getEntityClazz(){
		return entityClazz;
	}

}
