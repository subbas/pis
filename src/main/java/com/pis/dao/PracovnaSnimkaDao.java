package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.PracovnaSnimka;

@Repository
public class PracovnaSnimkaDao implements Dao<PracovnaSnimka> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(PracovnaSnimka snimka) {
		getCurrentSession().save(snimka);
	}

	public void update(PracovnaSnimka snimka) {
		PracovnaSnimka snimkaToUpdate = getEntity(snimka.getId());
		//snimkaToUpdate.setName(snimka.getName());
		//snimkaToUpdate.setRating(snimka.getRating());
		getCurrentSession().update(snimkaToUpdate);
		
	}

	public PracovnaSnimka getEntity(int id) {
		PracovnaSnimka snimka = (PracovnaSnimka) getCurrentSession().get(PracovnaSnimka.class, id);
		return snimka;
	}

	public void delete(int id) {
		PracovnaSnimka snimka = getEntity(id);
		if (snimka != null)
			getCurrentSession().delete(snimka);
	}

	@SuppressWarnings("unchecked")
	public List<PracovnaSnimka> getEntities() {
		return getCurrentSession().createQuery("from PracovnaSnimka").list();
	}

}
