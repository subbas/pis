package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.ZamestnanecDao;
import com.pis.model.Zamestnanec;

@Service
@Transactional
public class ZamestnanecService implements EntityService<Zamestnanec> {
	
	@Autowired
	private ZamestnanecDao entityDao;

	public void add(Zamestnanec item) {
		entityDao.add(item);		
	}

	public void update(Zamestnanec item) {
		entityDao.update(item);
	}

	public Zamestnanec getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<Zamestnanec> getEntities() {
		return entityDao.getEntities();
	}

	@Override
	public int getLastId() {
		return entityDao.getLastId();
	}

	@Override
	public void updateVelinar(Zamestnanec entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(Zamestnanec entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(Zamestnanec entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Zamestnanec> getAllStrojnik() {
		return entityDao.getAllStrojnik();
	}

	@Override
	public List<Zamestnanec> getAllVelinar() {
		return entityDao.getAllVelinar();
	}

	@Override
	public List<Zamestnanec> getAllMajster() {
		return entityDao.getAllMajster();
	}



	@Override
	public Zamestnanec getEntity(String meno) {
		// TODO Auto-generated method stub
		return null;
	}
}
