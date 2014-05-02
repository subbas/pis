package com.pis.dao;

import java.util.List;

import com.pis.model.Zamestnanec;


public interface Dao<T> {
	public void add(T entity);
	public void update(T entity);
	public void updateVelinar(T entity);
	public void updateStrojnik(T entity);
	public void updateVeduci(T entity);
	public T getEntity(int id);
	public void delete(int id);
	public List<T> getEntities();
	public int getLastId();
	public List<Zamestnanec> getAllStrojnik();
	public List<Zamestnanec> getAllVelinar();
	public List<Zamestnanec> getAllMajster();
	public T getEntity(String meno);
	
}
