package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.OdprasovanieDaoImpl;
import com.pis.model.Odprasovanie;

@Service
@Transactional
public class OdprasovanieServiceImpl implements EntityService<Odprasovanie> {
	
	@Autowired
	private OdprasovanieDaoImpl entityDao;

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
}
