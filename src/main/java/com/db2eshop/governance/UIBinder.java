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
package com.db2eshop.governance;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIEmbedded;
import com.db2eshop.annotations.bindings.UIHide;
import com.db2eshop.gui.component.io.EntityForm;
import com.db2eshop.gui.component.io.LabeledForm;
import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.persistence.support.AbstractDao;
import com.db2eshop.util.ClassUtil;
import com.db2eshop.util.StringUtil;
import com.db2eshop.util.orm.TableValueEntityResolver;

/**
 * <p>UIBinder class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class UIBinder {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private TableValueEntityResolver tableValueEntityResolver;
	
	/**
	 * <p>create.</p>
	 *
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 * @return a {@link java.util.Map} object.
	 */
	@SuppressWarnings("unchecked")
	public Map<String, LabeledForm<?>> create(AbstractModel<?> entity) {
		Class<? extends AbstractModel<?>> entityClazz = (Class<? extends AbstractModel<?>>) entity.getClass();
		Map<String, LabeledForm<?>> ui = create(entityClazz);
		return mixin(ui, entity);
	}

	/**
	 * <p>create.</p>
	 *
	 * @param entityClazz a {@link java.lang.Class} object.
	 * @return a {@link java.util.Map} object.
	 */
	public Map<String, LabeledForm<?>> create(Class<? extends AbstractModel<?>> entityClazz) {
		Map<String, LabeledForm<?>> ui = new HashMap<String, LabeledForm<?>>();

		Field[] fields = entityClazz.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			if(field.getAnnotation(UIHide.class)!=null){
				continue;
			}
			UIBind uiBind = field.getAnnotation(UIBind.class);
			UIEmbedded uiEmbedded = field.getAnnotation(UIEmbedded.class);
			if (uiBind != null && uiEmbedded == null) {
				Class<? extends LabeledForm<?>> inputClazz = uiBind.value();
				if (inputClazz != null) {
					try {
						LabeledForm<?> input = ClassUtil.newInstance(inputClazz);
						input.setLabel(StringUtil.nominilize(fieldName));
						ui.put(fieldName, input);
					} catch (RuntimeException e) {
						log.error("Could not instantiate: " + inputClazz.getName(), e);
					}
				} else {
					log.error("No bound LabeledInput found on: " + entityClazz.getName() + "#" + fieldName);
				}
			} else if (uiBind == null && uiEmbedded != null) {
				Class<?> clazz = field.getType();
				if(!AbstractModel.class.isAssignableFrom(clazz)){
					log.error("Property " + entityClazz.getName() + "#" + fieldName + " is forced to be embedded entity but not assignable to AbstractModel. Skipping.");
				}else{
					AbstractDao<?> daoToBeSet = tableValueEntityResolver.getDao(clazz);
					EntityForm input = new EntityForm(daoToBeSet);
					input.setLabel(StringUtil.nominilize(fieldName));
					ui.put(fieldName, input);
				}
			} else {
				if (uiBind != null && uiEmbedded != null) {
					log.error("Property " + entityClazz.getName() + "#" + fieldName + " is forced to be embedded and bound. Skipping.");
				} else {
					log.debug("Property " + entityClazz.getName() + "#" + fieldName + " not forced to be bound.");
				}
			}
		}
		return ui;
	}

	/**
	 * <p>mixin.</p>
	 *
	 * @param ui a {@link java.util.Map} object.
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 * @return a {@link java.util.Map} object.
	 */
	public Map<String, LabeledForm<?>> mixin(Map<String, LabeledForm<?>> ui, AbstractModel<?> entity) {
		AbstractDao<?> dao = tableValueEntityResolver.getDao(entity.getClass());
		dao.getHibernateTemplate().refresh(entity);
		
		Class<?> entityClazz = entity.getClass();
		for (String propertyName : ui.keySet()) {
			Field field = getField(entityClazz, propertyName);
			if (field != null) {
				field.setAccessible(true);
				Object object;
				try {
					object = field.get(entity);
				} catch (Exception e) {
					log.error(e);
					continue;
				}
				ui.get(propertyName).setValue(object);
			}
		}
		return ui;
	}

	private Field getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			return null;
		}
	}
}
