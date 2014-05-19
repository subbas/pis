package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.ZamestnanecDaoImpl;
import com.pis.model.Zamestnanec;

@Service
@Transactional
public class ZamestnanecServiceImpl implements ZamestnanecService {
	
	@Autowired
	private ZamestnanecDaoImpl entityDao;

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
}
