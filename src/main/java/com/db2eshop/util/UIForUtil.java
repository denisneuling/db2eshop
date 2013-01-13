package com.db2eshop.util;

import com.db2eshop.annotations.bindings.UIFor;

/**
 * <p>UIForUtil class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class UIForUtil {

	/**
	 * <p>retrieveUIFor.</p>
	 *
	 * @param object a {@link java.lang.Object} object.
	 * @param <T> a T object.
	 * @return a {@link java.lang.Class} object.
	 */
	public static <T> Class<?> retrieveUIFor(Object object) {
		if (object == null) {
			return null;
		}

		Class<?> clazz = object.getClass();
		UIFor uifor = clazz.getAnnotation(UIFor.class);
		if(uifor!=null){
			Class<?> uiforClass = uifor.value();
			if(uiforClass==null){
				throw new RuntimeException("UIFor class of "+object.getClass().getName()+"cannot be null.");
			}else{
				return uiforClass;
			}
		}
		return null;
	}
}
