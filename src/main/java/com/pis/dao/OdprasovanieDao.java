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
		
		odprasovanieToUpdate.setHerdingCas(odprasovanie.getHerdingCas());
		odprasovanieToUpdate.setHerdingChodVyprazdnovaciehoZariadenia(odprasovanie.getHerdingChodVyprazdnovaciehoZariadenia());
		odprasovanieToUpdate.setHerdingCistiaceImpulzy(odprasovanie.getHerdingCistiaceImpulzy());
		odprasovanieToUpdate.setM10_cas(odprasovanie.getM10_cas());
		odprasovanieToUpdate.setM10_datum_zmeny_hadic(odprasovanie.getM10_datum_zmeny_hadic());
		odprasovanieToUpdate.setM10_funkcnost_tesnost(odprasovanie.getM10_funkcnost_tesnost());
		odprasovanieToUpdate.setM10_podtlak(odprasovanie.getM10_podtlak());
		odprasovanieToUpdate.setM115_cas(odprasovanie.getM115_cas());
		odprasovanieToUpdate.setM115_chod_snekoveho_dopravnika(odprasovanie.getM115_chod_snekoveho_dopravnika());
		odprasovanieToUpdate.setM115_funkcnost_celistvost(odprasovanie.getM115_funkcnost_celistvost());
		odprasovanieToUpdate.setM115_funkcnost_oklepavacieho_zariadenia(odprasovanie.getM115_funkcnost_oklepavacieho_zariadenia());
		odprasovanieToUpdate.setM116_cas(odprasovanie.getM116_cas());
		odprasovanieToUpdate.setM116_datum_zmeny_hadic(odprasovanie.getM116_datum_zmeny_hadic());
		odprasovanieToUpdate.setM116_podtlak(odprasovanie.getM116_podtlak());
		odprasovanieToUpdate.setM116_funkcnost_tesnost(odprasovanie.getM116_funkcnost_tesnost());
		odprasovanieToUpdate.setM117_cas(odprasovanie.getM117_cas());
		odprasovanieToUpdate.setM117_datum_zmeny_hadic(odprasovanie.getM117_datum_zmeny_hadic());
		odprasovanieToUpdate.setM117_podtlak(odprasovanie.getM117_podtlak());
		odprasovanieToUpdate.setM117_funkcnost_tesnost(odprasovanie.getM117_funkcnost_tesnost());
		odprasovanieToUpdate.setM12_cas(odprasovanie.getM12_cas());
		odprasovanieToUpdate.setM12_datum_zmeny_hadic(odprasovanie.getM12_datum_zmeny_hadic());
		odprasovanieToUpdate.setM12_podtlak(odprasovanie.getM12_podtlak());
		odprasovanieToUpdate.setM12_funkcnost_tesnost(odprasovanie.getM12_funkcnost_tesnost());
		odprasovanieToUpdate.setScheuchCas(odprasovanie.getScheuchCas());
		odprasovanieToUpdate.setScheuchPodtlak(odprasovanie.getScheuchPodtlak());
		odprasovanieToUpdate.setScheuchMembranoveVentily(odprasovanie.getScheuchMembranoveVentily());
		odprasovanieToUpdate.setScheuchSneky(odprasovanie.getScheuchSneky());
		
		
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
