package com.pis.formular;

import java.util.Date;

import com.pis.model.Maerz;
import com.pis.model.Odprasovanie;
import com.pis.model.ZamMaerz;
import com.pis.model.Zamestnanec;


public class Formular {

	private static Formular instance = null;
	private Maerz maerz;
	private Odprasovanie odprasovanie;
	private ZamMaerz zamMaerz;
	private String majster;
	private String velinar;
	private String strojnik;
	private String datum;
	private int zmena;
	
	
	

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getZmena() {
		return zmena;
	}

	public void setZmena(int zmena) {
		this.zmena = zmena;
	}

	
	public String getMajster() {
		return majster;
	}

	public void setMajster(String majster) {
		this.majster = majster;
	}

	public String getVelinar() {
		return velinar;
	}

	public void setVelinar(String velinar) {
		this.velinar = velinar;
	}

	public String getStrojnik() {
		return strojnik;
	}

	public void setStrojnik(String strojnik) {
		this.strojnik = strojnik;
	}

	public Formular() {
	}
	
	public static Formular getInstance() {
		if(instance ==  null) {
			instance = new Formular();
		} 
		return instance;
	}
	
	public static void setInstance(Formular form) {
		instance = form;
	}

	public Maerz getMaerz() {
		return maerz;
	}

	public void setMaerz(Maerz maerz) {
		this.maerz = maerz;
	}

	public Odprasovanie getOdprasovanie() {
		return odprasovanie;
	}

	public void setOdprasovanie(Odprasovanie odprasovanie) {
		this.odprasovanie = odprasovanie;
	}

	public ZamMaerz getZamMaerz() {
		return zamMaerz;
	}

	public void setZamMaerz(ZamMaerz zamMaerz) {
		this.zamMaerz = zamMaerz;
	}
}
