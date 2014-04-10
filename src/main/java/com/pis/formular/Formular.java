package com.pis.formular;

import com.pis.model.Maerz;
import com.pis.model.Odprasovanie;
import com.pis.model.PracovnaSnimka;
import com.pis.model.ZamMaerz;

public class Formular {

	private Maerz maerz;
	private PracovnaSnimka pracSnimka;
	private Odprasovanie odprasovanie;
	private ZamMaerz zamMaerz;

	public Formular() {
	}

	public Maerz getMaerz() {
		return maerz;
	}

	public void setMaerz(Maerz maerz) {
		this.maerz = maerz;
	}

	public PracovnaSnimka getPracSnimka() {
		return pracSnimka;
	}

	public void setPracSnimka(PracovnaSnimka pracSnimka) {
		this.pracSnimka = pracSnimka;
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
