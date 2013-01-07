package com.db2eshop.util;

import com.db2eshop.annotations.bindings.UIFor;

public class UIForUtil {

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
