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
import com.db2eshop.gui.component.io.EmbeddedEntityInput;
import com.db2eshop.gui.component.io.LabeledInput;
import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.persistence.support.AbstractDao;
import com.db2eshop.util.ClassUtil;
import com.db2eshop.util.ctx.TableValueEntityResolver;

@Component
public class UIBinder {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private TableValueEntityResolver tableValueEntityResolver;
	
	@SuppressWarnings("unchecked")
	public Map<String, LabeledInput<?>> create(AbstractModel<?> entity) {
		Class<? extends AbstractModel<?>> entityClazz = (Class<? extends AbstractModel<?>>) entity.getClass();
		Map<String, LabeledInput<?>> ui = create(entityClazz);
		return mixin(ui, entity);
	}

	public Map<String, LabeledInput<?>> create(Class<? extends AbstractModel<?>> entityClazz) {
		Map<String, LabeledInput<?>> ui = new HashMap<String, LabeledInput<?>>();

		Field[] fields = entityClazz.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			if(field.getAnnotation(UIHide.class)!=null){
				continue;
			}
			UIBind uiBind = field.getAnnotation(UIBind.class);
			UIEmbedded uiEmbedded = field.getAnnotation(UIEmbedded.class);
			if (uiBind != null && uiEmbedded == null) {
				Class<? extends LabeledInput<?>> inputClazz = uiBind.value();
				if (inputClazz != null) {
					try {
						LabeledInput<?> input = ClassUtil.newInstance(inputClazz);
						input.setLabel(fieldName);
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
					EmbeddedEntityInput input = new EmbeddedEntityInput(daoToBeSet);
					input.setLabel(fieldName);
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

	public Map<String, LabeledInput<?>> mixin(Map<String, LabeledInput<?>> ui, AbstractModel<?> entity) {
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
