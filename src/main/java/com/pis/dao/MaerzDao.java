package com.pis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.model.Maerz;
import com.pis.model.Zamestnanec;

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
		//velinar
		maerzToUpdate.setBriketizackaKonStav(maerz.getBriketizackaKonStav());
		maerzToUpdate.setBriketizackaPocStav(maerz.getBriketizackaPocStav());
		maerzToUpdate.setChodPece(maerz.getChodPece());
		maerzToUpdate.setFilter_M20_kon_stav(maerz.getFilter_M20_kon_stav());
		maerzToUpdate.setFilter_M20_poc_stav(maerz.getFilter_M20_poc_stav());
		maerzToUpdate.setStavLekarnicky(maerz.getStavLekarnicky());
		maerzToUpdate.setVyrobaVapenecVsadzka17FrakciaVapenca(maerz.getVyrobaVapenecVsadzka17FrakciaVapenca());
		maerzToUpdate.setVyrobaVapenecVsadzka17Skut(maerz.getVyrobaVapenecVsadzka17Skut());
		maerzToUpdate.setVyrobaVapenecVsadzka35FrakciaVapenca(maerz.getVyrobaVapenecVsadzka35FrakciaVapenca());
		maerzToUpdate.setVyrobaVapenecVsadzka35Skut(maerz.getVyrobaVapenecVsadzka35Skut());
		maerzToUpdate.setVyrobaVapenecVsadzka6FrakciaVapenca(maerz.getVyrobaVapenecVsadzka6FrakciaVapenca());
		maerzToUpdate.setVyrobaVapenecVsadzka6Skut(maerz.getVyrobaVapenecVsadzka6Skut());
		maerzToUpdate.setVyrobaVapno17Skut(maerz.getVyrobaVapno17Skut());
		maerzToUpdate.setVyrobaVapno35Skut(maerz.getVyrobaVapno35Skut());
		maerzToUpdate.setVyrobaVapno6Skut(maerz.getVyrobaVapno6Skut());
		maerzToUpdate.setZasobnik1Druh(maerz.getZasobnik1Druh());
		maerzToUpdate.setZasobnik1Plnenie(maerz.getZasobnik1Plnenie());
		maerzToUpdate.setZasobnik2Druh(maerz.getZasobnik2Druh());
		maerzToUpdate.setZasobnik2Plnenie(maerz.getZasobnik2Plnenie());
		maerzToUpdate.setZasobnik5Druh(maerz.getZasobnik5Druh());
		maerzToUpdate.setZasobnik5Plnenie(maerz.getZasobnik5Plnenie());
		maerzToUpdate.setZasobnikNovaLanovkaDruh(maerz.getZasobnikNovaLanovkaDruh());
		maerzToUpdate.setZasobnikNovaLanovkaPlnenie(maerz.getZasobnikNovaLanovkaPlnenie());
		maerzToUpdate.setPracovnaSnimkaVelinar(maerz.getPracovnaSnimkaVelinar());
		//strojnik
		maerzToUpdate.setNeodstranenePoruchy(maerz.getNeodstranenePoruchy());
		maerzToUpdate.setKontrolaOchrannychKrytov(maerz.getKontrolaOchrannychKrytov());
		maerzToUpdate.setStavIzolatorovVentilatorov(maerz.getStavIzolatorovVentilatorov());
		maerzToUpdate.setStavObeznychKoliesVentilatorov(maerz.getStavObeznychKoliesVentilatorov());
		maerzToUpdate.setStavPotrubiaVzduchotechniky(maerz.getStavPotrubiaVzduchotechniky());
		maerzToUpdate.setVysledokKontrolyTechnologickehoZariadenia(maerz.getVysledokKontrolyTechnologickehoZariadenia());
		maerzToUpdate.setPracovnaSnimkaStrojnik(maerz.getPracovnaSnimkaStrojnik());
		//veduci
		maerzToUpdate.setVyrobaVapno17Plan(maerz.getVyrobaVapno17Plan());
		maerzToUpdate.setVyrobaVapno35Plan(maerz.getVyrobaVapno35Plan());
		maerzToUpdate.setVyrobaVapno6Plan(maerz.getVyrobaVapno6Plan());
		
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
	
	public int getLastId() {
		return (Integer)getCurrentSession().createQuery("select max(id) from Maerz").uniqueResult();
	}

	@Override
	public void updateVelinar(Maerz maerz) {
		Maerz maerzToUpdate = getEntity(maerz.getId());
		maerzToUpdate.setBriketizackaKonStav(maerz.getBriketizackaKonStav());
		maerzToUpdate.setBriketizackaPocStav(maerz.getBriketizackaPocStav());
		maerzToUpdate.setChodPece(maerz.getChodPece());
		maerzToUpdate.setFilter_M20_kon_stav(maerz.getFilter_M20_kon_stav());
		maerzToUpdate.setFilter_M20_poc_stav(maerz.getFilter_M20_poc_stav());
		maerzToUpdate.setStavLekarnicky(maerz.getStavLekarnicky());
		maerzToUpdate.setVyrobaVapenecVsadzka17FrakciaVapenca(maerz.getVyrobaVapenecVsadzka17FrakciaVapenca());
		maerzToUpdate.setVyrobaVapenecVsadzka17Skut(maerz.getVyrobaVapenecVsadzka17Skut());
		maerzToUpdate.setVyrobaVapenecVsadzka35FrakciaVapenca(maerz.getVyrobaVapenecVsadzka35FrakciaVapenca());
		maerzToUpdate.setVyrobaVapenecVsadzka35Skut(maerz.getVyrobaVapenecVsadzka35Skut());
		maerzToUpdate.setVyrobaVapenecVsadzka6FrakciaVapenca(maerz.getVyrobaVapenecVsadzka6FrakciaVapenca());
		maerzToUpdate.setVyrobaVapenecVsadzka6Skut(maerz.getVyrobaVapenecVsadzka6Skut());
		maerzToUpdate.setVyrobaVapno17Skut(maerz.getVyrobaVapno17Skut());
		maerzToUpdate.setVyrobaVapno35Skut(maerz.getVyrobaVapno35Skut());
		maerzToUpdate.setVyrobaVapno6Skut(maerz.getVyrobaVapno6Skut());
		maerzToUpdate.setZasobnik1Druh(maerz.getZasobnik1Druh());
		maerzToUpdate.setZasobnik1Plnenie(maerz.getZasobnik1Plnenie());
		maerzToUpdate.setZasobnik2Druh(maerz.getZasobnik2Druh());
		maerzToUpdate.setZasobnik2Plnenie(maerz.getZasobnik2Plnenie());
		maerzToUpdate.setZasobnik5Druh(maerz.getZasobnik5Druh());
		maerzToUpdate.setZasobnik5Plnenie(maerz.getZasobnik5Plnenie());
		maerzToUpdate.setZasobnikNovaLanovkaDruh(maerz.getZasobnikNovaLanovkaDruh());
		maerzToUpdate.setZasobnikNovaLanovkaPlnenie(maerz.getZasobnikNovaLanovkaPlnenie());
		maerzToUpdate.setPracovnaSnimkaVelinar(maerz.getPracovnaSnimkaVelinar().replaceAll("\n", "<br/>"));
		getCurrentSession().update(maerzToUpdate);
		
		
	}

	@Override
	public void updateStrojnik(Maerz maerz) {
		Maerz maerzToUpdate = getEntity(maerz.getId());
		maerzToUpdate.setNeodstranenePoruchy(maerz.getNeodstranenePoruchy());
		maerzToUpdate.setKontrolaOchrannychKrytov(maerz.getKontrolaOchrannychKrytov());
		maerzToUpdate.setStavIzolatorovVentilatorov(maerz.getStavIzolatorovVentilatorov());
		maerzToUpdate.setStavObeznychKoliesVentilatorov(maerz.getStavObeznychKoliesVentilatorov());
		maerzToUpdate.setStavPotrubiaVzduchotechniky(maerz.getStavPotrubiaVzduchotechniky());
		maerzToUpdate.setVysledokKontrolyTechnologickehoZariadenia(maerz.getVysledokKontrolyTechnologickehoZariadenia());
		maerzToUpdate.setPracovnaSnimkaStrojnik(maerz.getPracovnaSnimkaStrojnik());
		getCurrentSession().update(maerzToUpdate);
		
	}

	@Override
	public void updateVeduci(Maerz maerz) {
		Maerz maerzToUpdate = getEntity(maerz.getId());
		maerzToUpdate.setVyrobaVapno17Plan(maerz.getVyrobaVapno17Plan());
		maerzToUpdate.setVyrobaVapno35Plan(maerz.getVyrobaVapno35Plan());
		maerzToUpdate.setVyrobaVapno6Plan(maerz.getVyrobaVapno6Plan());
		getCurrentSession().update(maerzToUpdate);
		
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
