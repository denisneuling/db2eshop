package com.db2eshop.persistence.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * The generic interface for create-, update-, and delete- operations onto ORM
 * side
 * 
 * @author Denis Neuling (denisneuling@gmail.com)
 */
public interface GenericDaoCrudOperations<T> {

	/**
	 * Deletes the serializable entity with type t from the table which is
	 * associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param t
	 *            the typed entity
	 */
	public void delete(T entity);

	/**
	 * Deletes all serializable entities with type t from the table which is
	 * associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param t
	 *            the typed entity
	 */
	public void deleteAll();

	/**
	 * Retrieves all serializable entities with type t from the table which is
	 * associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @return ts all retrievable typed entities with type t
	 */
	public List<T> findAll();

	/**
	 * Saves the serializable entity with type t at the table which is
	 * associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param t
	 *            the typed entity
	 * @return id the serializable id of the just inserted entity
	 */
	public Serializable save(T entity);

	/**
	 * Saves a collection of entites
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param ts
	 *            the collection of typed entities
	 */
	public void saveAll(Collection<T> entities);

	/**
	 * Saves a collection of entites
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param ts
	 *            the collection of typed entities by the overloaded method
	 */
	public void saveAll(T... entities);

	/**
	 * Saves or updates the serializable entity with type t at the table which
	 * is associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param t
	 *            the typed entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * Saves or updates a collection of typed entities to the table which is
	 * associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param ts
	 *            the collection of entities to process
	 */
	public void saveOrUpdateAll(Collection<T> ts);

	/**
	 * Saves or updates a collection of typed entities to the table which is
	 * associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param ts
	 *            the bunch of entities which are given by the overloaded method
	 */
	public void saveOrUpdateAll(T... ts);

	/**
	 * Updates the serializable entity with type t at the table which is
	 * associated with the concerning type
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param t
	 *            the typed entity
	 */
	public void update(T entity);

	/**
	 * Updates all given entities
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param entities
	 */
	public void updateAll(Collection<T> entities);

	/**
	 * Updates all given entities
	 * 
	 * @author Denis Neuling <dn@cloudcontrol.de>
	 * 
	 * @param entities
	 */
	public void updateAll(T... entities);
}