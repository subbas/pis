package com.pis.service;

import java.util.List;

public interface EntityService<T> {
	public void add(T entity);
	public void update(T entity);
	public T getEntity(int id);
	public void delete(int id);
	public List<T> getEntities();

}
