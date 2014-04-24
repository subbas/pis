package com.pis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zam_maerz database table.
 * 
 */
@Entity
@Table(name="zam_maerz")
public class ZamMaerz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private int zmena;

	//bi-directional many-to-one association to Maerz
	@ManyToOne
	@JoinColumn(name="id_maerz")
	private Maerz maerz;

	//bi-directional many-to-one association to Zamestnanec
	@ManyToOne
	@JoinColumn(name="id_velinar")
	private Zamestnanec zamestnanec1;

	//bi-directional many-to-one association to Zamestnanec
	@ManyToOne
	@JoinColumn(name="id_majster")
	private Zamestnanec zamestnanec2;

	//bi-directional many-to-one association to Zamestnanec
	@ManyToOne
	@JoinColumn(name="id_strojnik")
	private Zamestnanec zamestnanec3;

	public ZamMaerz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getZmena() {
		return this.zmena;
	}

	public void setZmena(int zmena) {
		this.zmena = zmena;
	}

	public Maerz getMaerz() {
		return this.maerz;
	}

	public void setMaerz(Maerz maerz) {
		this.maerz = maerz;
	}

	public Zamestnanec getZamestnanec1() {
		return this.zamestnanec1;
	}

	public void setZamestnanec1(Zamestnanec zamestnanec1) {
		this.zamestnanec1 = zamestnanec1;
	}

	public Zamestnanec getZamestnanec2() {
		return this.zamestnanec2;
	}

	public void setZamestnanec2(Zamestnanec zamestnanec2) {
		this.zamestnanec2 = zamestnanec2;
	}

	public Zamestnanec getZamestnanec3() {
		return this.zamestnanec3;
	}

	public void setZamestnanec3(Zamestnanec zamestnanec3) {
		this.zamestnanec3 = zamestnanec3;
	}

}