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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * ClassUtil class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ClassUtil {

	/**
	 * <p>getClassAnnotationValue.</p>
	 *
	 * @param source a {@link java.lang.Class} object.
	 * @param annotation a {@link java.lang.Class} object.
	 * @param attributeName a {@link java.lang.String} object.
	 * @param expected a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a T object.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T getClassAnnotationValue(Class source, Class annotation, String attributeName, Class<T> expected) {
		Annotation instance = source.getAnnotation(annotation);
		T value = null;
		if (instance != null) {
			try {
				value = (T) instance.annotationType().getMethod(attributeName).invoke(instance);
			} catch (Exception ex) {
			}
		}
		return value;
	}
	
	/**
	 * <p>getAnnotatedFields.</p>
	 *
	 * @param clazz a {@link java.lang.Class} object.
	 * @param annotationClass a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a {@link java.util.List} object.
	 */
	public static <T> List<Field> getAnnotatedFields(Class<?> clazz, Class<? extends Annotation> annotationClass) {
		List<Field> annotatedFields = new LinkedList<Field>();
		Field[] allFields = getAllDeclaredFields(clazz);
		for (Field field : allFields) {
			if (null != (field.getAnnotation(annotationClass))) {
				annotatedFields.add(field);
			}
		}
		return annotatedFields;
	}

	/**
	 * <p>getAllDeclaredFields.</p>
	 *
	 * @param clazz a {@link java.lang.Class} object.
	 * @return an array of {@link java.lang.reflect.Field} objects.
	 */
	public static Field[] getAllDeclaredFields(Class<?> clazz) {
		Field[] declaredFields = clazz.getDeclaredFields();
		Class<?> superClass = clazz.getSuperclass();
		if (superClass != null && superClass != Object.class) {
			declaredFields = ArrayUtils.concat(declaredFields, getAllDeclaredFields(superClass));
		}
		return declaredFields;
	}

	/**
	 * <p>getValueOf.</p>
	 *
	 * @param field a {@link java.lang.reflect.Field} object.
	 * @param reference a {@link java.lang.Object} object.
	 * @param referenceClazz a {@link java.lang.Class} object.
	 * @param referenceClazz a {@link java.lang.Class} object.
	 * @param valueType a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a T object.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValueOf(Field field, Object reference, Class<?> referenceClazz, Class<T> valueType) {
		try {
			field.setAccessible(true);
			Object toReturn = (T) field.get(reference);
			if(String.class.isInstance(valueType.getClass()) && !String.class.isInstance(toReturn.getClass())){
				toReturn = toReturn.toString();
			}
			return (T) toReturn;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * <p>getValueOf.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueType a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @param referenceClazz a {@link java.lang.Class} object.
	 * @param reference a {@link java.lang.Object} object.
	 * @return a T object.
	 */
	public static <T> T getValueOf(String fieldName, Object reference, Class<?> referenceClazz, Class<T> valueType) {
		try {
			Field field = referenceClazz.getDeclaredField(fieldName);
			field.setAccessible(true);

			@SuppressWarnings("unchecked")
			T toReturn = (T) field.get(reference);
			return toReturn;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * <p>getValueOfField.</p>
	 *
	 * @param field a {@link java.lang.reflect.Field} object.
	 * @param ref a {@link java.lang.Object} object.
	 * @return a {@link java.lang.Object} object.
	 */
	public static Object getValueOfField(Field field, Object ref) {
		field.setAccessible(true);
		Object value = null;
		try {
			value = field.get(ref);
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
		return value;
	}
	
	/**
	 * <p>newInstance.</p>
	 *
	 * @param clazz a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a T object.
	 */
	public static <T> T newInstance(Class<T> clazz){
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * <p>newSilentInstance.</p>
	 *
	 * @param clazz a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a T object.
	 */
	public static <T> T newSilentInstance(Class<T> clazz){
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * <p>getTypesOfProperties.</p>
	 *
	 * @param fieldNames an array of {@link java.lang.String} objects.
	 * @param parentClazz a {@link java.lang.Class} object.
	 * @return an array of {@link java.lang.Class} objects.
	 */
	public static Class<?>[] getTypesOfProperties(String[] fieldNames, Class<?> parentClazz){
		if(fieldNames==null || parentClazz==null){
			return new Class<?>[0];
		}
		Class<?>[] types = new Class<?>[fieldNames.length];
		for(int i = 0; i < fieldNames.length; i++){
			try {
				types[i] = parentClazz.getDeclaredField(fieldNames[i]).getType();
			} catch (Exception e) {
				types[i] = Object.class;
			} 
		}
		return types;
	}
}
