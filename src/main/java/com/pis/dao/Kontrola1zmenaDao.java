/*package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Kontrola1zmena;

@Repository
public class Kontrola1zmenaDao implements Dao<Kontrola1zmena> {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Kontrola1zmena kontrola1zmena) {
		getCurrentSession().save(kontrola1zmena);
	}

	public void update(Kontrola1zmena kontrola1zmena) {
		Kontrola1zmena kontrolaToUpdate = getEntity(kontrola1zmena.getId());
		// rolaToUpdate.setName(kontrola1zmena.getName());
		// rolaToUpdate.setRating(kontrola1zmena.getRating());
		getCurrentSession().update(kontrolaToUpdate);

	}

	public Kontrola1zmena getEntity(int id) {
		Kontrola1zmena kontrola1zmena = (Kontrola1zmena) getCurrentSession().get(Kontrola1zmena.class, id);
		return kontrola1zmena;
	}

	public void delete(int id) {
		Kontrola1zmena kontrola1zmena = getEntity(id);
		if (kontrola1zmena != null)
			getCurrentSession().delete(kontrola1zmena);
	}

	@SuppressWarnings("unchecked")
	public List<Kontrola1zmena> getEntities() {
		return getCurrentSession().createQuery("from Kontrola1zmenaDao").list();
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateVelinar(Kontrola1zmena entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(Kontrola1zmena entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(Kontrola1zmena entity) {
		// TODO Auto-generated method stub
		
	}

}
*/