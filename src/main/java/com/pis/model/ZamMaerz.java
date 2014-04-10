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
	@JoinColumn(name="id_zam")
	private Zamestnanec zamestnanec;

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

	public Zamestnanec getZamestnanec() {
		return this.zamestnanec;
	}

	public void setZamestnanec(Zamestnanec zamestnanec) {
		this.zamestnanec = zamestnanec;
	}

}