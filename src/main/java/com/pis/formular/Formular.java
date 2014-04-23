package com.pis.formular;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pis.model.Maerz;
import com.pis.model.Odprasovanie;
import com.pis.model.PracovnaSnimka;
import com.pis.model.ZamMaerz;
import com.pis.service.EntityService;


public class Formular {

	private static Formular instance = null;
	private Maerz maerz;
	private List<PracovnaSnimka> pracovnaSnimkas = new ArrayList<PracovnaSnimka>();
	private Odprasovanie odprasovanie;
	private ZamMaerz zamMaerz;
	
	
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

	public List<PracovnaSnimka> getPracovnaSnimkas() {
		return pracovnaSnimkas;
	}

	public void setPracovnaSnimkas(List<PracovnaSnimka> pracovnaSnimkas) {
		this.pracovnaSnimkas = pracovnaSnimkas;
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
