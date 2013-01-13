package com.db2eshop.governance.service.model.api;

import java.util.List;

/**
 * <p>CrudService interface.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
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
