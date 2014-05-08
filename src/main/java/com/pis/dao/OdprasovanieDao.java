package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Odprasovanie;
import com.pis.model.Zamestnanec;

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

	@Override
	public int getLastId() {
		return (Integer)getCurrentSession().createQuery("select max(id) from Odprasovanie").uniqueResult();
	}

	@Override
	public void updateVelinar(Odprasovanie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrojnik(Odprasovanie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVeduci(Odprasovanie entity) {
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


	@Override
	public Odprasovanie getEntity(String meno) {
		// TODO Auto-generated method stub
		return null;
	}

}
