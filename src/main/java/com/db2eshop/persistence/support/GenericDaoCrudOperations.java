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
package com.db2eshop.persistence.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * The generic interface for create-, update-, and delete- operations onto ORM
 * side
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public interface GenericDaoCrudOperations<T> {

	/**
	 * Deletes the serializable entity with type t from the table which is
	 * associated with the concerning type
	 *
	 * @param entity
	 *            a T object.
	 */
	public void delete(T entity);

	/**
	 * Deletes all serializable entities with type t from the table which is
	 * associated with the concerning type
	 */
	public void deleteAll();

	/**
	 * Retrieves all serializable entities with type t from the table which is
	 * associated with the concerning type
	 *
	 * @return ts all retrievable typed entities with type t
	 */
	public List<T> findAll();

	/**
	 * Saves the serializable entity with type t at the table which is
	 * associated with the concerning type
	 *
	 * @return id the serializable id of the just inserted entity
	 * @param entity
	 *            a T object.
	 */
	public Serializable save(T entity);

	/**
	 * Saves a collection of entites
	 *
	 * @param entities
	 *            a {@link java.util.Collection} object.
	 */
	public void saveAll(Collection<T> entities);

	/**
	 * Saves a collection of entites
	 *
	 * @param entities
	 *            a T object.
	 */
	public void saveAll(T... entities);

	/**
	 * Saves or updates the serializable entity with type t at the table which
	 * is associated with the concerning type
	 *
	 * @param entity
	 *            a T object.
	 */
	public void saveOrUpdate(T entity);

	/**
	 * Saves or updates a collection of typed entities to the table which is
	 * associated with the concerning type
	 *
	 * @param ts
	 *            the collection of entities to process
	 */
	public void saveOrUpdateAll(Collection<T> ts);

	/**
	 * Saves or updates a collection of typed entities to the table which is
	 * associated with the concerning type
	 *
	 * @param ts
	 *            the bunch of entities which are given by the overloaded method
	 */
	public void saveOrUpdateAll(T... ts);

	/**
	 * Updates the serializable entity with type t at the table which is
	 * associated with the concerning type
	 *
	 * @param entity
	 *            a T object.
	 */
	public void update(T entity);

	/**
	 * Updates all given entities
	 *
	 * @param entities
	 *            a {@link java.util.Collection} object.
	 */
	public void updateAll(Collection<T> entities);

	/**
	 * Updates all given entities
	 *
	 * @param entities
	 *            a T object.
	 */
	public void updateAll(T... entities);
}
