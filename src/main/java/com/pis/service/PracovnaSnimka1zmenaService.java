package com.pis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pis.dao.PracovnaSnimka1zmenaDao;
import com.pis.model.PracovnaSnimka1zmena;

@Service
@Transactional
public class PracovnaSnimka1zmenaService implements EntityService<PracovnaSnimka1zmena> {
	
	@Autowired
	private PracovnaSnimka1zmenaDao entityDao;

	public void add(PracovnaSnimka1zmena item) {
		entityDao.add(item);		
	}

	public void update(PracovnaSnimka1zmena item) {
		entityDao.update(item);
	}

	public PracovnaSnimka1zmena getEntity(int id) {
		return entityDao.getEntity(id);
	}

	public void delete(int id) {
		entityDao.delete(id);
	}

	public List<PracovnaSnimka1zmena> getEntities() {
		return entityDao.getEntities();
	}
}
