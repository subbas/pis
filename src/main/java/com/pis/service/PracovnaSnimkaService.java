/*package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.PracovnaSnimkaDao;
import com.pis.model.PracovnaSnimka;

@Service
@Transactional
public class PracovnaSnimkaService implements EntityService<PracovnaSnimka> {
	
	@Autowired
	private PracovnaSnimkaDao entityDao;

	public void add(PracovnaSnimka item) {
		entityDao.add(item);		
	}

	public void update(PracovnaSnimka item) {
		entityDao.update(item);
	}

	public PracovnaSnimka getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<PracovnaSnimka> getEntities() {
		return entityDao.getEntities();
	}

	@Override
	public int getLastId() {
		return entityDao.getLastId();
	}

	@Override
	public void updateVelinar(PracovnaSnimka entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(PracovnaSnimka entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(PracovnaSnimka entity) {
		// TODO Auto-generated method stub
		
	}
}
*/