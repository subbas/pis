package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Odprasovanie;

@Repository
public class OdprasovanieDao implements Dao<Odprasovanie> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Odprasovanie odprasovanie) {
		getCurrentSession().save(odprasovanie);
	}

	public void update(Odprasovanie odprasovanie) {
		Odprasovanie odprasovanieToUpdate = getEntity(odprasovanie.getId());
		//odprasovanieToUpdate.setName(odprasovanie.getName());
		//odprasovanieToUpdate.setRating(odprasovanie.getRating());
		getCurrentSession().update(odprasovanieToUpdate);
		
	}

	public Odprasovanie getEntity(int id) {
		Odprasovanie odprasovanie = (Odprasovanie) getCurrentSession().get(Odprasovanie.class, id);
		return odprasovanie;
	}

	public void delete(int id) {
		Odprasovanie odprasovanie = getEntity(id);
		if (odprasovanie != null)
			getCurrentSession().delete(odprasovanie);
	}

	@SuppressWarnings("unchecked")
	public List<Odprasovanie> getEntities() {
		return getCurrentSession().createQuery("from Odprasovanie").list();
	}

}