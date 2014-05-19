package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Rola;

@Repository
public class RolaDaoImpl implements Dao<Rola> {
	
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

}
