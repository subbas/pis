/*package com.pis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


*//**
 * The persistent class for the kontrola_1zmena database table.
 * 
 *//*
@Entity
@Table(name="kontrola_1zmena")
public class Kontrola1zmena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="poistny_ventil_kontrola")
	private int poistnyVentilKontrola;

	@Column(name="poistny_ventil_zavada")
	private int poistnyVentilZavada;

	@Column(name="tlakomer_kontrola")
	private int tlakomerKontrola;

	@Column(name="tlakomer_zavada")
	private int tlakomerZavada;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena1")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas1;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena2")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas2;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena3")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas3;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena4")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas4;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena5")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas5;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena6")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas6;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena7")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas7;

	//bi-directional many-to-one association to PracovnaSnimka1zmena
	@OneToMany(mappedBy="kontrola1zmena8")
	private List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas8;

	public Kontrola1zmena() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoistnyVentilKontrola() {
		return this.poistnyVentilKontrola;
	}

	public void setPoistnyVentilKontrola(int poistnyVentilKontrola) {
		this.poistnyVentilKontrola = poistnyVentilKontrola;
	}

	public int getPoistnyVentilZavada() {
		return this.poistnyVentilZavada;
	}

	public void setPoistnyVentilZavada(int poistnyVentilZavada) {
		this.poistnyVentilZavada = poistnyVentilZavada;
	}

	public int getTlakomerKontrola() {
		return this.tlakomerKontrola;
	}

	public void setTlakomerKontrola(int tlakomerKontrola) {
		this.tlakomerKontrola = tlakomerKontrola;
	}

	public int getTlakomerZavada() {
		return this.tlakomerZavada;
	}

	public void setTlakomerZavada(int tlakomerZavada) {
		this.tlakomerZavada = tlakomerZavada;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas1() {
		return this.pracovnaSnimka1zmenas1;
	}

	public void setPracovnaSnimka1zmenas1(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas1) {
		this.pracovnaSnimka1zmenas1 = pracovnaSnimka1zmenas1;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas1(PracovnaSnimka1zmena pracovnaSnimka1zmenas1) {
		getPracovnaSnimka1zmenas1().add(pracovnaSnimka1zmenas1);
		pracovnaSnimka1zmenas1.setKontrola1zmena1(this);

		return pracovnaSnimka1zmenas1;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas1(PracovnaSnimka1zmena pracovnaSnimka1zmenas1) {
		getPracovnaSnimka1zmenas1().remove(pracovnaSnimka1zmenas1);
		pracovnaSnimka1zmenas1.setKontrola1zmena1(null);

		return pracovnaSnimka1zmenas1;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas2() {
		return this.pracovnaSnimka1zmenas2;
	}

	public void setPracovnaSnimka1zmenas2(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas2) {
		this.pracovnaSnimka1zmenas2 = pracovnaSnimka1zmenas2;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas2(PracovnaSnimka1zmena pracovnaSnimka1zmenas2) {
		getPracovnaSnimka1zmenas2().add(pracovnaSnimka1zmenas2);
		pracovnaSnimka1zmenas2.setKontrola1zmena2(this);

		return pracovnaSnimka1zmenas2;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas2(PracovnaSnimka1zmena pracovnaSnimka1zmenas2) {
		getPracovnaSnimka1zmenas2().remove(pracovnaSnimka1zmenas2);
		pracovnaSnimka1zmenas2.setKontrola1zmena2(null);

		return pracovnaSnimka1zmenas2;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas3() {
		return this.pracovnaSnimka1zmenas3;
	}

	public void setPracovnaSnimka1zmenas3(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas3) {
		this.pracovnaSnimka1zmenas3 = pracovnaSnimka1zmenas3;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas3(PracovnaSnimka1zmena pracovnaSnimka1zmenas3) {
		getPracovnaSnimka1zmenas3().add(pracovnaSnimka1zmenas3);
		pracovnaSnimka1zmenas3.setKontrola1zmena3(this);

		return pracovnaSnimka1zmenas3;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas3(PracovnaSnimka1zmena pracovnaSnimka1zmenas3) {
		getPracovnaSnimka1zmenas3().remove(pracovnaSnimka1zmenas3);
		pracovnaSnimka1zmenas3.setKontrola1zmena3(null);

		return pracovnaSnimka1zmenas3;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas4() {
		return this.pracovnaSnimka1zmenas4;
	}

	public void setPracovnaSnimka1zmenas4(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas4) {
		this.pracovnaSnimka1zmenas4 = pracovnaSnimka1zmenas4;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas4(PracovnaSnimka1zmena pracovnaSnimka1zmenas4) {
		getPracovnaSnimka1zmenas4().add(pracovnaSnimka1zmenas4);
		pracovnaSnimka1zmenas4.setKontrola1zmena4(this);

		return pracovnaSnimka1zmenas4;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas4(PracovnaSnimka1zmena pracovnaSnimka1zmenas4) {
		getPracovnaSnimka1zmenas4().remove(pracovnaSnimka1zmenas4);
		pracovnaSnimka1zmenas4.setKontrola1zmena4(null);

		return pracovnaSnimka1zmenas4;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas5() {
		return this.pracovnaSnimka1zmenas5;
	}

	public void setPracovnaSnimka1zmenas5(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas5) {
		this.pracovnaSnimka1zmenas5 = pracovnaSnimka1zmenas5;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas5(PracovnaSnimka1zmena pracovnaSnimka1zmenas5) {
		getPracovnaSnimka1zmenas5().add(pracovnaSnimka1zmenas5);
		pracovnaSnimka1zmenas5.setKontrola1zmena5(this);

		return pracovnaSnimka1zmenas5;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas5(PracovnaSnimka1zmena pracovnaSnimka1zmenas5) {
		getPracovnaSnimka1zmenas5().remove(pracovnaSnimka1zmenas5);
		pracovnaSnimka1zmenas5.setKontrola1zmena5(null);

		return pracovnaSnimka1zmenas5;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas6() {
		return this.pracovnaSnimka1zmenas6;
	}

	public void setPracovnaSnimka1zmenas6(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas6) {
		this.pracovnaSnimka1zmenas6 = pracovnaSnimka1zmenas6;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas6(PracovnaSnimka1zmena pracovnaSnimka1zmenas6) {
		getPracovnaSnimka1zmenas6().add(pracovnaSnimka1zmenas6);
		pracovnaSnimka1zmenas6.setKontrola1zmena6(this);

		return pracovnaSnimka1zmenas6;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas6(PracovnaSnimka1zmena pracovnaSnimka1zmenas6) {
		getPracovnaSnimka1zmenas6().remove(pracovnaSnimka1zmenas6);
		pracovnaSnimka1zmenas6.setKontrola1zmena6(null);

		return pracovnaSnimka1zmenas6;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas7() {
		return this.pracovnaSnimka1zmenas7;
	}

	public void setPracovnaSnimka1zmenas7(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas7) {
		this.pracovnaSnimka1zmenas7 = pracovnaSnimka1zmenas7;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas7(PracovnaSnimka1zmena pracovnaSnimka1zmenas7) {
		getPracovnaSnimka1zmenas7().add(pracovnaSnimka1zmenas7);
		pracovnaSnimka1zmenas7.setKontrola1zmena7(this);

		return pracovnaSnimka1zmenas7;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas7(PracovnaSnimka1zmena pracovnaSnimka1zmenas7) {
		getPracovnaSnimka1zmenas7().remove(pracovnaSnimka1zmenas7);
		pracovnaSnimka1zmenas7.setKontrola1zmena7(null);

		return pracovnaSnimka1zmenas7;
	}

	public List<PracovnaSnimka1zmena> getPracovnaSnimka1zmenas8() {
		return this.pracovnaSnimka1zmenas8;
	}

	public void setPracovnaSnimka1zmenas8(List<PracovnaSnimka1zmena> pracovnaSnimka1zmenas8) {
		this.pracovnaSnimka1zmenas8 = pracovnaSnimka1zmenas8;
	}

	public PracovnaSnimka1zmena addPracovnaSnimka1zmenas8(PracovnaSnimka1zmena pracovnaSnimka1zmenas8) {
		getPracovnaSnimka1zmenas8().add(pracovnaSnimka1zmenas8);
		pracovnaSnimka1zmenas8.setKontrola1zmena8(this);

		return pracovnaSnimka1zmenas8;
	}

	public PracovnaSnimka1zmena removePracovnaSnimka1zmenas8(PracovnaSnimka1zmena pracovnaSnimka1zmenas8) {
		getPracovnaSnimka1zmenas8().remove(pracovnaSnimka1zmenas8);
		pracovnaSnimka1zmenas8.setKontrola1zmena8(null);

		return pracovnaSnimka1zmenas8;
	}

}*/