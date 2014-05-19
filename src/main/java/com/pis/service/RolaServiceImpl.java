package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.RolaDaoImpl;
import com.pis.model.Rola;

@Service
@Transactional
public class RolaServiceImpl implements EntityService<Rola> {
	
	@Autowired
	private RolaDaoImpl entityDao;

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
		return entityDao.getLastId();
	}
}
