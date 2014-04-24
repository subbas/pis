/*package com.pis.model;

import java.io.Serializable;
import javax.persistence.*;


*//**
 * The persistent class for the pracovna_snimka_1zmena database table.
 * 
 *//*
@Entity
@Table(name="pracovna_snimka_1zmena")
public class PracovnaSnimka1zmena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_62384")
	private Kontrola1zmena kontrola1zmena1;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_62400")
	private Kontrola1zmena kontrola1zmena2;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_susica")
	private Kontrola1zmena kontrola1zmena3;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_vs_776")
	private Kontrola1zmena kontrola1zmena4;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_vzduch_delo_5269")
	private Kontrola1zmena kontrola1zmena5;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_vzduch_delo_5270")
	private Kontrola1zmena kontrola1zmena6;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_vzduch_delo_5271")
	private Kontrola1zmena kontrola1zmena7;

	//bi-directional many-to-one association to Kontrola1zmena
	@ManyToOne
	@JoinColumn(name="tlak_nadoba_vzduch_delo_5272")
	private Kontrola1zmena kontrola1zmena8;

	//bi-directional many-to-one association to Maerz
	@ManyToOne
	@JoinColumn(name="id_maerz")
	private Maerz maerz;

	public PracovnaSnimka1zmena() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kontrola1zmena getKontrola1zmena1() {
		return this.kontrola1zmena1;
	}

	public void setKontrola1zmena1(Kontrola1zmena kontrola1zmena1) {
		this.kontrola1zmena1 = kontrola1zmena1;
	}

	public Kontrola1zmena getKontrola1zmena2() {
		return this.kontrola1zmena2;
	}

	public void setKontrola1zmena2(Kontrola1zmena kontrola1zmena2) {
		this.kontrola1zmena2 = kontrola1zmena2;
	}

	public Kontrola1zmena getKontrola1zmena3() {
		return this.kontrola1zmena3;
	}

	public void setKontrola1zmena3(Kontrola1zmena kontrola1zmena3) {
		this.kontrola1zmena3 = kontrola1zmena3;
	}

	public Kontrola1zmena getKontrola1zmena4() {
		return this.kontrola1zmena4;
	}

	public void setKontrola1zmena4(Kontrola1zmena kontrola1zmena4) {
		this.kontrola1zmena4 = kontrola1zmena4;
	}

	public Kontrola1zmena getKontrola1zmena5() {
		return this.kontrola1zmena5;
	}

	public void setKontrola1zmena5(Kontrola1zmena kontrola1zmena5) {
		this.kontrola1zmena5 = kontrola1zmena5;
	}

	public Kontrola1zmena getKontrola1zmena6() {
		return this.kontrola1zmena6;
	}

	public void setKontrola1zmena6(Kontrola1zmena kontrola1zmena6) {
		this.kontrola1zmena6 = kontrola1zmena6;
	}

	public Kontrola1zmena getKontrola1zmena7() {
		return this.kontrola1zmena7;
	}

	public void setKontrola1zmena7(Kontrola1zmena kontrola1zmena7) {
		this.kontrola1zmena7 = kontrola1zmena7;
	}

	public Kontrola1zmena getKontrola1zmena8() {
		return this.kontrola1zmena8;
	}

	public void setKontrola1zmena8(Kontrola1zmena kontrola1zmena8) {
		this.kontrola1zmena8 = kontrola1zmena8;
	}

	public Maerz getMaerz() {
		return this.maerz;
	}

	public void setMaerz(Maerz maerz) {
		this.maerz = maerz;
	}

}*/