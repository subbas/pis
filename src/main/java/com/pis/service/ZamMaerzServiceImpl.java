package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.ZamMaerzDaoImpl;
import com.pis.model.ZamMaerz;

@Service
@Transactional
public class ZamMaerzServiceImpl implements EntityService<ZamMaerz> {
	
	@Autowired
	private ZamMaerzDaoImpl entityDao;

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
}
