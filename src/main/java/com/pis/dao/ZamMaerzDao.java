package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.ZamMaerz;
import com.pis.model.Zamestnanec;

@Repository
public class ZamMaerzDao implements Dao<ZamMaerz> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(ZamMaerz zamMaerz) {
		getCurrentSession().save(zamMaerz);
	}

	public void update(ZamMaerz zamMaerz) {
		ZamMaerz zamMaerzToUpdate = getEntity(zamMaerz.getId());
		//zamMaerzToUpdate.setName(zamMaerz.getName());
		//zamMaerzToUpdate.setRating(zamMaerz.getRating());
		getCurrentSession().update(zamMaerzToUpdate);
		
	}

	public ZamMaerz getEntity(int id) {
		ZamMaerz zamMaerz = (ZamMaerz) getCurrentSession().get(ZamMaerz.class, id);
		return zamMaerz;
	}

	public void delete(int id) {
		ZamMaerz zamMaerz = getEntity(id);
		if (zamMaerz != null)
			getCurrentSession().delete(zamMaerz);
	}

	@SuppressWarnings("unchecked")
	public List<ZamMaerz> getEntities() {
		return getCurrentSession().createQuery("from ZamMaerz").list();
	}

	@Override
	public int getLastId() {
		return (Integer)getCurrentSession().createQuery("select max(id) from ZamMaerz").uniqueResult();
	}

	@Override
	public void updateVelinar(ZamMaerz entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(ZamMaerz entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(ZamMaerz entity) {
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
