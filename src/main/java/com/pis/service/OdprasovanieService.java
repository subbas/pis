package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.OdprasovanieDao;
import com.pis.model.Odprasovanie;
import com.pis.model.Zamestnanec;

@Service
@Transactional
public class OdprasovanieService implements EntityService<Odprasovanie> {
	
	@Autowired
	private OdprasovanieDao entityDao;

	public void add(Odprasovanie item) {
		entityDao.add(item);		
	}

	public void update(Odprasovanie item) {
		entityDao.update(item);
	}

	public Odprasovanie getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<Odprasovanie> getEntities() {
		return entityDao.getEntities();
	}

	@Override
	public int getLastId() {
		return entityDao.getLastId();
	}

	@Override
	public void updateVelinar(Odprasovanie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(Odprasovanie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(Odprasovanie entity) {
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
	public Odprasovanie getEntity(String meno) {
		// TODO Auto-generated method stub
		return null;
	}
}
