package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.MaerzDao;
import com.pis.model.Maerz;

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
}
