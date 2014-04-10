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
}
