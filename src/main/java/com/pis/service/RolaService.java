package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.RolaDao;
import com.pis.model.Rola;
import com.pis.model.Zamestnanec;

@Service
@Transactional
public class RolaService implements EntityService<Rola> {
	
	@Autowired
	private RolaDao entityDao;

	public void add(Rola item) {
		entityDao.add(item);		
	}

	public void update(Rola item) {
		entityDao.update(item);
	}

	public Rola getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<Rola> getEntities() {
		return entityDao.getEntities();
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateVelinar(Rola entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(Rola entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(Rola entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Zamestnanec> getAllStrojnik() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zamestnanec> getAllVelinar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zamestnanec> getAllMajster() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Rola getEntity(String meno) {
		// TODO Auto-generated method stub
		return null;
	}
}
