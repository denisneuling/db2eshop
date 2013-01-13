package com.db2eshop.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.db2eshop.annotations.bindings.UIHide;
import com.db2eshop.model.support.AbstractModel;

/**
 * <p>EntityUtil class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class EntityUtil {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getRootLogger();

	/**
	 * <p>getRowMeta.</p>
	 *
	 * @param entity a {@link java.lang.Class} object.
	 * @return a {@link java.util.Map} object.
	 */
	public static Map<String, Annotation[]> getRowMeta(Class<?> entity) {
		Map<String, Annotation[]> entityMeta = new HashMap<String, Annotation[]>();
		if (entity != null) {
			Field[] fields = entity.getDeclaredFields();

			for (Field field : fields) {
				Annotation[] annotations = field.getAnnotations();
				if (field.getAnnotation(UIHide.class) == null) {
					if (annotations.length > 0) {
						entityMeta.put(field.getName(), annotations);
					}
				}
			}
		}
		return entityMeta;
	}

	/**
	 * <p>getRowMeta.</p>
	 *
	 * @param entity a {@link com.db2eshop.model.support.AbstractModel} object.
	 * @return a {@link java.util.Map} object.
	 */
	public static Map<String, Annotation[]> getRowMeta(AbstractModel<?> entity) {
		Class<?> entityClass = null;
		if (entity != null) {
			entityClass = entity.getClass();
		}
		return getRowMeta(entityClass);
	}

	/**
	 * <p>asTableModel.</p>
	 *
	 * @param entityClazz a {@link java.lang.Class} object.
	 * @return a {@link javax.swing.table.DefaultTableModel} object.
	 */
	public static DefaultTableModel asTableModel(Class<?> entityClazz) {
		if (entityClazz == null) {
			return null;
		}

		Map<String, Annotation[]> entityMeta = EntityUtil.getRowMeta(entityClazz);
		Set<String> rows = entityMeta.keySet();
		ArrayList<String> arrayList = new ArrayList<String>(rows);

		Collections.sort(arrayList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.equals("id")) {
					return -1;
				}
				return 0;
			}
		});
		return new DefaultTableModel(arrayList.toArray(), 0);
	}
}
