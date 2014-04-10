package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Maerz;

@Repository
public class MaerzDao implements Dao<Maerz> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Maerz maerz) {
		getCurrentSession().save(maerz);
	}

	public void update(Maerz maerz) {
		Maerz maerzToUpdate = getEntity(maerz.getId());
		//maerzToUpdate.setName(maerz.getName());
		//maerzToUpdate.setRating(maerz.getRating());
		getCurrentSession().update(maerzToUpdate);
		
	}

	public Maerz getEntity(int id) {
		Maerz maerz = (Maerz) getCurrentSession().get(Maerz.class, id);
		return maerz;
	}

	public void delete(int id) {
		Maerz maerz = getEntity(id);
		if (maerz != null)
			getCurrentSession().delete(maerz);
	}

	@SuppressWarnings("unchecked")
	public List<Maerz> getEntities() {
		return getCurrentSession().createQuery("from Maerz").list();
	}

}
