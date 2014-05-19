package com.pis.service;

import java.util.List;

import com.pis.model.Zamestnanec;

public interface ZamestnanecService {
	public void add(Zamestnanec entity);
	public void update(Zamestnanec entity);
	public Zamestnanec getEntity(int id);
	public void delete(int id);
	public List<Zamestnanec> getEntities();
	public int getLastId();
	public List<Zamestnanec> getAllStrojnik();
	public List<Zamestnanec> getAllVelinar();
	public List<Zamestnanec> getAllMajster();
}
