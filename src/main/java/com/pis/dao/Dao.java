package com.pis.dao;

import java.util.List;


public interface Dao<T> {
	public void add(T entity);
	public void update(T entity);
	public T getEntity(int id);
	public void delete(int id);
	public List<T> getEntities();
	public int getLastId();
}
