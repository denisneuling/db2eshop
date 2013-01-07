package com.db2eshop.governance.service.model.api;

import java.util.List;

public interface CrudService<T> {

	public List<T> loadEntireTable();
	
	public T getById(Long id);
	
	public void update(T entity);
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public void refresh(T entity);
}
