package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.PracovnaSnimka1zmena;

@Repository
public class PracovnaSnimka1zmenaDao implements Dao<PracovnaSnimka1zmena> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(PracovnaSnimka1zmena snimka) {
		getCurrentSession().save(snimka);
	}

	public void update(PracovnaSnimka1zmena snimka) {
		PracovnaSnimka1zmena snimkaToUpdate = getEntity(snimka.getId());
		//snimkaToUpdate.setName(snimka.getName());
		//snimkaToUpdate.setRating(snimka.getRating());
		getCurrentSession().update(snimkaToUpdate);
		
	}

	public PracovnaSnimka1zmena getEntity(int id) {
		PracovnaSnimka1zmena snimka = (PracovnaSnimka1zmena) getCurrentSession().get(PracovnaSnimka1zmena.class, id);
		return snimka;
	}

	public void delete(int id) {
		PracovnaSnimka1zmena snimka = getEntity(id);
		if (snimka != null)
			getCurrentSession().delete(snimka);
	}

	@SuppressWarnings("unchecked")
	public List<PracovnaSnimka1zmena> getEntities() {
		return getCurrentSession().createQuery("from PracovnaSnimka1zmena").list();
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
