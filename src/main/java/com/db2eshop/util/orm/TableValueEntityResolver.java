/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.db2eshop.util.orm;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.model.Article;
import com.db2eshop.model.ArticleType;
import com.db2eshop.model.Booking;
import com.db2eshop.model.Customer;
import com.db2eshop.model.Employee;
import com.db2eshop.model.Import;
import com.db2eshop.model.Sale;
import com.db2eshop.model.Shipping;
import com.db2eshop.model.Supplier;
import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.persistence.ArticleDao;
import com.db2eshop.persistence.ArticleTypeDao;
import com.db2eshop.persistence.BookingDao;
import com.db2eshop.persistence.CustomerDao;
import com.db2eshop.persistence.EmployeeDao;
import com.db2eshop.persistence.ImportDao;
import com.db2eshop.persistence.SaleDao;
import com.db2eshop.persistence.ShippingDao;
import com.db2eshop.persistence.SupplierDao;
import com.db2eshop.persistence.support.AbstractDao;
import com.db2eshop.util.ClassUtil;
import com.db2eshop.util.DateUtil;

/**
 * <p>TableValueEntityResolver class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
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
	
	@Autowired
	private BookingDao bookingDao;

	private volatile HashMap<Class<?>, AbstractDao<?>> entityDao;

	/**
	 * <p>setValue.</p>
	 *
	 * @param target a T object.
	 * @param <T> a T object.
	 * @param propertyName a {@link java.lang.String} object.
	 * @param property a {@link java.lang.Object} object.
	 * @return a T object.
	 */
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

	/**
	 * <p>box.</p>
	 *
	 * @param property a {@link java.lang.Object} object.
	 * @param to a {@link java.lang.Class} object.
	 * @return a {@link java.lang.Object} object.
	 */
	@SuppressWarnings("rawtypes")
	public Object box(Object property, Class<?> to) {
		if(property==null){
			return property;
		}
		if (property instanceof String && Double.class.isAssignableFrom(to)) {
			if(((String)property).isEmpty()){
				return 0D;
			}
			return new Double((String) property);
		}
		if (property instanceof String && Long.class.isAssignableFrom(to)) {
			return new Long((String) property);
		}
		if (property instanceof String && Integer.class.isAssignableFrom(to)) {
			return new Integer((String) property);
		}
		if (property instanceof String && Date.class.isAssignableFrom(to)) {
			return DateUtil.asDate((String)property);
		}
		
		if(AbstractModel.class.isAssignableFrom(to)){
			Long id = null;
			if(property instanceof String){
				if(((String)property).isEmpty()){
					return null;
				}
				id = new Long((String) property);
			}else if(property instanceof AbstractModel){
				id = ((AbstractModel)property).getId();
			}else if(property instanceof Long){
				id = (Long)property;
			}
			AbstractModel<?> model = entityDao.get(to).findById(id);
			return model;
			
		}
		return to.cast(property);
	}
	
	/**
	 * <p>asTableData.</p>
	 *
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 * @param fields an array of {@link java.lang.String} objects.
	 * @return an array of {@link java.lang.Object} objects.
	 */
	public Object[] asTableData(AbstractModel<?> entity, String[] fields) {
		if (entity == null) {
			throw new RuntimeException("Entity cannot be null");
		}
		if (fields == null) {
			throw new RuntimeException("Entity extraction fields cannot be null");
		}
		
		Object[] data = new Object[fields.length];
		int index = 0;
		Class<?> entityClass = entity.getClass();
		for(String field : fields){
			try {
				Object object = ClassUtil.getValueOf(field, entity, entityClass, entityClass.getDeclaredField(field).getType());
				data[index] = object;
			} catch (Exception e) {
				log.error("Field "+field+" could not been found",e);
				data[index] = e.getMessage();
			}
			index++;
		}
		return data;
	}
	
	/**
	 * <p>getDao.</p>
	 *
	 * @param entityClazz a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a {@link com.db2eshop.persistence.support.AbstractDao} object.
	 */
	public <T> AbstractDao<?> getDao(Class<T> entityClazz){
		return (AbstractDao<?>) entityDao.get(entityClazz);
	}

	/** {@inheritDoc} */
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
		entityDao.put(Booking.class, bookingDao);
	}
}
