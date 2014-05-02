package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.ZamMaerzDao;
import com.pis.model.ZamMaerz;
import com.pis.model.Zamestnanec;

@Service
@Transactional
public class ZamMaerzService implements EntityService<ZamMaerz> {
	
	@Autowired
	private ZamMaerzDao entityDao;

	public void add(ZamMaerz item) {
		entityDao.add(item);		
	}

	public void update(ZamMaerz item) {
		entityDao.update(item);
	}

	public ZamMaerz getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<ZamMaerz> getEntities() {
		return entityDao.getEntities();
	}

	@Override
	public int getLastId() {
		return entityDao.getLastId();
	}

	@Override
	public void updateVelinar(ZamMaerz entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(ZamMaerz entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(ZamMaerz entity) {
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
	public ZamMaerz getEntity(String meno) {
		// TODO Auto-generated method stub
		return null;
	}
}
