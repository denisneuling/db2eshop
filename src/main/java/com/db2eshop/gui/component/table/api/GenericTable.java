package com.db2eshop.gui.component.table.api;

import java.awt.event.MouseListener;
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

import com.db2eshop.gui.component.table.listener.TableEntityModelListener;
import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.util.ClassUtil;
import com.db2eshop.util.EntityUtil;
import com.db2eshop.util.UIForUtil;
import com.db2eshop.util.ctx.TableValueEntityResolver;

@Component
public abstract class GenericTable<T extends AbstractModel<T>> extends JTable implements InitializingBean, ApplicationListener<ApplicationEvent> {
	private static final long serialVersionUID = 1180747329897017816L;
	protected Logger log = Logger.getLogger(this.getClass());

	private Class<T> entityClazz;
	private volatile String tableName = this.getClass().getSimpleName();
	protected String[] columnNames;

	@Autowired
	protected TableValueEntityResolver tableValueEntityResolver;

	private volatile boolean ready = false;

	private TableEntityModelListener<T> tableEntityModelListener;

	public String getTableName() {
		return tableName;
	}

	public GenericTable() {
	}

	protected MouseListener getMouseListener() {
		return null;
	};

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
		
		updateAble = mixin(values, updateAble);
		if (ready) {
			try {
				onRowChange(updateAble);
			} catch (RuntimeException re) {
				log.error(re);
			}
		}
	}

	public Object[] getRowAt(int row) {
		Object[] result = new Object[columnNames.length];

		for (int column = 0; column < columnNames.length; column++) {
			result[column] = this.getModel().getValueAt(row, column);
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	protected T mixin(Object[] values, AbstractModel<T> oldEntity) {
		if (values.length != columnNames.length) {
			throw new RuntimeException("ColumnNames lenght unqual value lenght!");
		}

		for (int i = 0; i < values.length; i++) {
			oldEntity = (AbstractModel<T>) tableValueEntityResolver.setValue(columnNames[i], values[i], oldEntity);
		}

		return (T) oldEntity;
	}

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
				this.setRowSorter(sorter);
			}
		}

		this.addMouseListener(getMouseListener());

		tableEntityModelListener = new TableEntityModelListener<T>(this);
		this.getModel().addTableModelListener(tableEntityModelListener);
	}
	
	protected void addRow(T entity){
		((DefaultTableModel)getModel()).addRow(asTableData(entity));
	}

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

	@Override
	public final void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			onApplicationReady();
			ready = true;
		}
	}

	public boolean isCellEditable(int row, int column) {
		return column != 0;
	}
	
	public abstract void onApplicationReady();

	public abstract void onRowChange(T entity);

}
