package com.db2eshop.util.ctx;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.model.Article;
import com.db2eshop.model.ArticleType;
import com.db2eshop.model.Customer;
import com.db2eshop.model.Employee;
import com.db2eshop.model.Import;
import com.db2eshop.model.Sale;
import com.db2eshop.model.Shipping;
import com.db2eshop.model.Supplier;
import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.persistence.ArticleDao;
import com.db2eshop.persistence.ArticleTypeDao;
import com.db2eshop.persistence.CustomerDao;
import com.db2eshop.persistence.EmployeeDao;
import com.db2eshop.persistence.ImportDao;
import com.db2eshop.persistence.SaleDao;
import com.db2eshop.persistence.ShippingDao;
import com.db2eshop.persistence.SupplierDao;
import com.db2eshop.persistence.support.AbstractDao;
import com.db2eshop.util.ClassUtil;

@Component
public class TableValueEntityResolver implements InitializingBean {
	protected Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private ArticleTypeDao articleTypeDao;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ImportDao importDao;
	
	@Autowired
	private SaleDao saleDao;
	
	@Autowired
	private ShippingDao shippingDao;
	
	@Autowired
	private SupplierDao supplierDao;

	private volatile HashMap<Class<?>, AbstractDao<?>> entityDao;

	public <T> T setValue(String propertyName, Object property, T target) {
		Field field;
		try {
			field = target.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			field.set(target, box(property, field.getType()));
			return target;
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public Object box(Object property, Class<?> to) {
		if(property==null){
			return property;
		}
		if (property instanceof String && Long.class.isAssignableFrom(to)) {
			return new Long((String) property);
		}
		if (property instanceof String && Integer.class.isAssignableFrom(to)) {
			return new Integer((String) property);
		}
		
		if(AbstractModel.class.isAssignableFrom(to)){
			Long id = null;
			if(property instanceof String){
				id = new Long((String) property);
			}
			AbstractModel<?> model = entityDao.get(to).findById(id);
			return model;
			
		}
		return to.cast(property);
	}
	
	public Object[] asTableData(AbstractModel<?> entity, String[] fields) {
		if (entity == null) {
			throw new RuntimeException("Entity cannot be null");
		}
		if (fields == null) {
			throw new RuntimeException("Entity extraction fields cannot be null");
		}
		
//		Session session = entityDao.get(entity.getClass()).getSessionFactory().openSession();
//		session.refresh(entity);
//		session.close();
		
		Object[] data = new Object[fields.length];
		int index = 0;
		Class<?> entityClass = entity.getClass();
		for(String field : fields){
			try {
				Object object = ClassUtil.getValueOf(field, entity, entityClass, entityClass.getDeclaredField(field).getType());
				if(object!=null && AbstractModel.class.isAssignableFrom(object.getClass())){
//					System.out.println(((AbstractModel<?>)object).getId());
//					entityDao.get(object.getClass()).refresh((AbstractModel)object);
//					object = ((AbstractModel<?>)object).getId();
				}
				data[index] = object;
			} catch (Exception e) {
				log.error("Field "+field+" could not been found",e);
				data[index] = e.getMessage();
			}
			index++;
		}
		return data;
	}
	
	public <T> AbstractDao<?> getDao(Class<T> entityClazz){
		return (AbstractDao<?>) entityDao.get(entityClazz);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		entityDao = new  HashMap<Class<?>, AbstractDao<?>>();
		
		entityDao.put(Article.class, articleDao);
		entityDao.put(ArticleType.class, articleTypeDao);
		entityDao.put(Customer.class, customerDao);
		entityDao.put(Employee.class, employeeDao);
		entityDao.put(Import.class, importDao);
		entityDao.put(Sale.class, saleDao);
		entityDao.put(Shipping.class, shippingDao);
		entityDao.put(Supplier.class, supplierDao);
	}
}
