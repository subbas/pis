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
	/*private int majsterID;
	private int velinarID;
	private int strojnikID;*/
	private String datum;
	private Integer zmena;
	

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Integer getZmena() {
		return zmena;
	}

	public void setZmena(Integer zmena) {
		this.zmena = zmena;
	}

	
	private Formular() {
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
