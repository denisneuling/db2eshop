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
package com.db2eshop.governance.service.model.api;

import java.util.List;

/**
 * <p>CrudService interface.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public interface CrudService<T> {

	/**
	 * <p>loadEntireTable.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<T> loadEntireTable();
	
	/**
	 * <p>getById.</p>
	 *
	 * @param id a {@link java.lang.Long} object.
	 * @return a T object.
	 */
	public T getById(Long id);
	
	/**
	 * <p>update.</p>
	 *
	 * @param entity a T object.
	 */
	public void update(T entity);
	
	/**
	 * <p>save.</p>
	 *
	 * @param entity a T object.
	 */
	public void save(T entity);
	
	/**
	 * <p>delete.</p>
	 *
	 * @param entity a T object.
	 */
	public void delete(T entity);
	
	/**
	 * <p>refresh.</p>
	 *
	 * @param entity a T object.
	 */
	public void refresh(T entity);
}
