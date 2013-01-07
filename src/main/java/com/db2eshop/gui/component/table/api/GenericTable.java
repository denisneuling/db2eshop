package com.db2eshop.gui.component.table.api;

import java.util.List;

import javax.swing.JTable;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.db2eshop.governance.spring.event.ContextEvent;
import com.db2eshop.models.support.AbstractModel;
import com.db2eshop.persistence.support.AbstractDao;
import com.db2eshop.util.UIForUtil;

@Component
public abstract class GenericTable<T extends AbstractModel<T>> extends JTable implements InitializingBean, ApplicationListener{
	private static final long serialVersionUID = 1180747329897017816L;
	protected Logger log = Logger.getLogger(this.getClass());

	private volatile String tableName = this.getClass().getSimpleName();
	
	public String getTableName(){
		return tableName;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected abstract AbstractDao<T> getDao();

	@Override
	public void afterPropertiesSet() throws Exception {
		if(!getClass().equals(GenericTable.class)){
			Class<?> entityClazz = UIForUtil.retrieveUIFor(this);
			if(entityClazz!=null){
				tableName = entityClazz.getSimpleName();
			}
		}
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			AbstractDao<T> dao = getDao();
			if(dao!=null){
				log.info("Retrieving initial dataset for "+getTableName());
				List<T> entities = dao.findAll();
			}
		}
	}
}
