package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Zamestnanec;

@Repository
public class ZamestnanecDaoImpl implements Dao<Zamestnanec>, ZamestnanecDao {
	
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
		zamestnanecToUpdate.setAktivny(zamestnanec.getAktivny());
		zamestnanecToUpdate.setHeslo(zamestnanec.getHeslo());
		zamestnanecToUpdate.setLogin(zamestnanec.getLogin());
		zamestnanecToUpdate.setMeno(zamestnanec.getMeno());
		zamestnanecToUpdate.setOsobneCislo(zamestnanec.getOsobneCislo());
		zamestnanecToUpdate.setPriezvisko(zamestnanec.getPriezvisko());
		zamestnanecToUpdate.setRolaBean(zamestnanec.getRolaBean());
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

	@Override
	public int getLastId() {
		return (Integer)getCurrentSession().createQuery("select max(id) from Zamestnanec").uniqueResult();
	}


	@Override
	public List<Zamestnanec> getAllStrojnik() {
		return getCurrentSession().createQuery("from Zamestnanec where rola='2'").list();
	}

	@Override
	public List<Zamestnanec> getAllVelinar() {
		return getCurrentSession().createQuery("from Zamestnanec where rola='1'").list();
	}

	@Override
	public List<Zamestnanec> getAllMajster() {
		return getCurrentSession().createQuery("from Zamestnanec where rola='4'").list();
	}
}
