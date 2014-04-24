package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Rola;
import com.pis.model.Zamestnanec;

@Repository
public class RolaDao implements Dao<Rola> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Rola rola) {
		getCurrentSession().save(rola);
	}

	public void update(Rola rola) {
		Rola rolaToUpdate = getEntity(rola.getId());
		//rolaToUpdate.setName(rola.getName());
		//rolaToUpdate.setRating(rola.getRating());
		getCurrentSession().update(rolaToUpdate);
		
	}

	public Rola getEntity(int id) {
		Rola rola = (Rola) getCurrentSession().get(Rola.class, id);
		return rola;
	}

	public void delete(int id) {
		Rola rola = getEntity(id);
		if (rola != null)
			getCurrentSession().delete(rola);
	}

	@SuppressWarnings("unchecked")
	public List<Rola> getEntities() {
		return getCurrentSession().createQuery("from Rola").list();
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateVelinar(Rola entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(Rola entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(Rola entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Zamestnanec> getAllStrojnik() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zamestnanec> getAllVelinar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zamestnanec> getAllMajster() {
		// TODO Auto-generated method stub
		return null;
	}

}
