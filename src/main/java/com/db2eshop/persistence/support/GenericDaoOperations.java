package com.db2eshop.persistence.support;

import java.io.Serializable;
import java.util.List;

/**
 * The generic interface for data access operations onto ORM side
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @param <T>
 * @version $Id: $Id
 */
public interface GenericDaoOperations<T> {

	/**
	 * Removes the given entity from the hibernate cache
	 *
	 * @param t
	 *            the entity to remove from the cache
	 */
	public void evict(T t);

	/**
	 * Retrieves a list of entities with the concerned value of the concerned
	 * field
	 *
	 * @param field
	 *            the field to evaluate
	 * @param value
	 *            the value to look for
	 * @return list the list of found entities
	 */
	public List<T> findBy(String field, Object value);

	/**
	 * Retrieves the serializable entities with the concerned id from the
	 * concerned table
	 *
	 * @param id
	 *            the serializable id of the entity
	 * @return t the entity which was retrieved
	 */
	public T findById(Serializable id);

	/**
	 * Retrieves an entitiy with the concerned value of the concerned field
	 *
	 * @param field
	 *            the field to evaluate
	 * @param value
	 *            the value to look for
	 * @return entitiy the retrieved entity
	 */
	public T findUniqueBy(String field, Object value);

	/**
	 * Flushes the hibernate Session
	 */
	public void flush();

	/**
	 * Merges a given entity
	 *
	 * @param t
	 *            the entity to merge
	 * @return entity the merged entity
	 */
	public T merge(T t);

	/**
	 * Persist a given entity
	 *
	 * @param t
	 *            the entity to persist
	 */
	public void persist(T t);

	/**
	 * Refreshs a given entity all over the persistence context
	 *
	 * @param t
	 *            the entity to refresh
	 */
	public void refresh(T t);

	/**
	 * Counts all rows of the associated entity
	 *
	 * @return count the count of rows
	 */
	public int rowCount();

	/**
	 * Sets the entity to readonly mode at the current persistence context
	 *
	 * @param readOnly
	 *            the boolean value of readonly
	 * @param entity
	 *            a T object.
	 */
	public void setReadOnly(T entity, boolean readOnly);

	/**
	 * Validates the entity
	 *
	 * @param entity
	 *            a T object.
	 */
	public void validate(T entity);

	/**
	 * SELECT * from <code><T></code> WHERE field1 = value1 AND field2 = value2;
	 *
	 * @param field1
	 *            the field to look for a given
	 * @param field2
	 *            the field to look for a given
	 * @param value1
	 *            the value to look for at a given field
	 * @param value2
	 *            the value to look for at a given field
	 * @return list the list of results by that query
	 */
	public List<T> findBy(String field1, String field2, Object value1, Object value2);

	/**
	 * SELECT * from <code><T></code> WHERE field1 = value1 AND field2 = value2
	 * AND field3 = value3;
	 *
	 * @param field1
	 *            the field to look for a given
	 * @param field2
	 *            the field to look for a given
	 * @param field3
	 *            the field to look for a given
	 * @param value1
	 *            the value to look for at a given field
	 * @param value2
	 *            the value to look for at a given field
	 * @param value3
	 *            the value to look for at a given field
	 * @return list the list of results by that query
	 */
	public List<T> findBy(String field1, String field2, String field3, Object value1, Object value2, Object value3);

	/**
	 * SELECT * from <code><T></code> WHERE field1 = value1 AND field2 = value2;
	 * but unique!
	 *
	 * @param field1
	 *            the field to look for a given
	 * @param field2
	 *            the field to look for a given
	 * @param value1
	 *            the value to look for at a given field
	 * @param value2
	 *            the value to look for at a given field
	 * @return list the list of results by that query
	 */
	public T findUniqueBy(String field1, String field2, Object value1, Object value2);

	/**
	 * SELECT * from <code><T></code> WHERE field1 = value1 AND field2 = value2
	 * AND field3 = value3; but unique!
	 *
	 * @param field1
	 *            the field to look for a given
	 * @param field2
	 *            the field to look for a given
	 * @param field3
	 *            the field to look for a given
	 * @param value1
	 *            the value to look for at a given field
	 * @param value2
	 *            the value to look for at a given field
	 * @param value3
	 *            the value to look for at a given field
	 * @return list the list of results by that query
	 */
	public T findUniqueBy(String field1, String field2, String field3, Object value1, Object value2, Object value3);
}
