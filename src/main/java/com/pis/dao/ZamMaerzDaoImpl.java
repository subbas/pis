package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.ZamMaerz;

@Repository
public class ZamMaerzDaoImpl implements Dao<ZamMaerz> {
	
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
		zamMaerzToUpdate.setDatum(zamMaerz.getDatum());
		zamMaerzToUpdate.setMaerz(zamMaerz.getMaerz());
		zamMaerzToUpdate.setZamestnanec1(zamMaerz.getZamestnanec1());
		zamMaerzToUpdate.setZamestnanec2(zamMaerz.getZamestnanec2());
		zamMaerzToUpdate.setZamestnanec3(zamMaerz.getZamestnanec3());
		zamMaerzToUpdate.setZmena(zamMaerz.getZmena());
		
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

}
