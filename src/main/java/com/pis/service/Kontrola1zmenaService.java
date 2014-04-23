package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.Kontrola1zmenaDao;
import com.pis.model.Kontrola1zmena;

@Service
@Transactional
public class Kontrola1zmenaService implements EntityService<Kontrola1zmena> {
	
	@Autowired
	private Kontrola1zmenaDao entityDao;

	public void add(Kontrola1zmena item) {
		entityDao.add(item);		
	}

	public void update(Kontrola1zmena item) {
		entityDao.update(item);
	}

	public Kontrola1zmena getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<Kontrola1zmena> getEntities() {
		return entityDao.getEntities();
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
