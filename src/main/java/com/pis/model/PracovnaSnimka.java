package com.pis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the pracovna_snimka database table.
 * 
 */
@Entity
@Table(name="pracovna_snimka")
public class PracovnaSnimka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Time dokedy;

	private Time odkedy;

	private String popis;

	//bi-directional many-to-one association to Maerz
	@ManyToOne
	@JoinColumn(name="id_maerz")
	private Maerz maerz;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="id_rola")
	private Rola rola;

	public PracovnaSnimka() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getDokedy() {
		return this.dokedy;
	}

	public void setDokedy(Time dokedy) {
		this.dokedy = dokedy;
	}

	public Time getOdkedy() {
		return this.odkedy;
	}

	public void setOdkedy(Time odkedy) {
		this.odkedy = odkedy;
	}

	public String getPopis() {
		return this.popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

	public Maerz getMaerz() {
		return this.maerz;
	}

	public void setMaerz(Maerz maerz) {
		this.maerz = maerz;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

}