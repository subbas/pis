package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.MaerzDao;
import com.pis.model.Maerz;
import com.pis.model.Zamestnanec;

@Service
@Transactional
public class MaerzService implements EntityService<Maerz> {
	
	@Autowired
	private MaerzDao entityDao;

	public void add(Maerz item) {
		entityDao.add(item);		
	}

	public void update(Maerz item) {
		entityDao.update(item);
	}

	public Maerz getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<Maerz> getEntities() {
		return entityDao.getEntities();
	}
	
	public int getLastId(){
		return entityDao.getLastId();
	}

	@Override
	public void updateVelinar(Maerz entity) {
		entityDao.updateVelinar(entity);	
	}

	@Override
	public void updateStrojnik(Maerz entity) {
		entityDao.updateStrojnik(entity);
	}

	@Override
	public void updateVeduci(Maerz entity) {
		entityDao.updateVeduci(entity);
		
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
}
