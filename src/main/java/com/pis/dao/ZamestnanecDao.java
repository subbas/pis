package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Zamestnanec;

@Repository
public class ZamestnanecDao implements Dao<Zamestnanec> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Zamestnanec zamestnanec) {
		getCurrentSession().save(zamestnanec);
	}

	public void update(Zamestnanec zamestnanec) {
		Zamestnanec zamestnanecToUpdate = getEntity(zamestnanec.getId());
		//zamestnanecToUpdate.setName(zamestnanec.getName());
		//zamestnanecToUpdate.setRating(zamestnanec.getRating());
		getCurrentSession().update(zamestnanecToUpdate);
		
	}

	public Zamestnanec getEntity(int id) {
		Zamestnanec zamestnanec = (Zamestnanec) getCurrentSession().get(Zamestnanec.class, id);
		return zamestnanec;
	}

	public void delete(int id) {
		Zamestnanec zamestnanec = getEntity(id);
		if (zamestnanec != null)
			getCurrentSession().delete(zamestnanec);
	}

	@SuppressWarnings("unchecked")
	public List<Zamestnanec> getEntities() {
		return getCurrentSession().createQuery("from Zamestnanec").list();
	}

}
