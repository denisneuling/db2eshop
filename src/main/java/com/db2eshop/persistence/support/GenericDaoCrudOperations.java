package com.db2eshop.persistence.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * The generic interface for create-, update-, and delete- operations onto ORM
 * side
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
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
