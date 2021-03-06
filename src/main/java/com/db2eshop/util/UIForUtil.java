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
