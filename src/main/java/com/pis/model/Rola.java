package com.pis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nazov;

	//bi-directional many-to-one association to PracovnaSnimka
	@OneToMany(mappedBy="rola")
	private List<PracovnaSnimka> pracovnaSnimkas;

	//bi-directional many-to-one association to Zamestnanec
	@OneToMany(mappedBy="rolaBean")
	private List<Zamestnanec> zamestnanecs;

	public Rola() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazov() {
		return this.nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public List<PracovnaSnimka> getPracovnaSnimkas() {
		return this.pracovnaSnimkas;
	}

	public void setPracovnaSnimkas(List<PracovnaSnimka> pracovnaSnimkas) {
		this.pracovnaSnimkas = pracovnaSnimkas;
	}

	public PracovnaSnimka addPracovnaSnimka(PracovnaSnimka pracovnaSnimka) {
		getPracovnaSnimkas().add(pracovnaSnimka);
		pracovnaSnimka.setRola(this);

		return pracovnaSnimka;
	}

	public PracovnaSnimka removePracovnaSnimka(PracovnaSnimka pracovnaSnimka) {
		getPracovnaSnimkas().remove(pracovnaSnimka);
		pracovnaSnimka.setRola(null);

		return pracovnaSnimka;
	}

	public List<Zamestnanec> getZamestnanecs() {
		return this.zamestnanecs;
	}

	public void setZamestnanecs(List<Zamestnanec> zamestnanecs) {
		this.zamestnanecs = zamestnanecs;
	}

	public Zamestnanec addZamestnanec(Zamestnanec zamestnanec) {
		getZamestnanecs().add(zamestnanec);
		zamestnanec.setRolaBean(this);

		return zamestnanec;
	}

	public Zamestnanec removeZamestnanec(Zamestnanec zamestnanec) {
		getZamestnanecs().remove(zamestnanec);
		zamestnanec.setRolaBean(null);

		return zamestnanec;
	}
	
	
}