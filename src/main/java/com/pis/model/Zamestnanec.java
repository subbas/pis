package com.pis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zamestnanec database table.
 * 
 */
@Entity
public class Zamestnanec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int aktivny;

	private String heslo;

	private String login;

	private String meno;

	private String priezvisko;

	//bi-directional many-to-one association to ZamMaerz
	@OneToMany(mappedBy="zamestnanec")
	private List<ZamMaerz> zamMaerzs;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="rola")
	private Rola rolaBean;

	public Zamestnanec() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAktivny() {
		return this.aktivny;
	}

	public void setAktivny(int aktivny) {
		this.aktivny = aktivny;
	}

	public String getHeslo() {
		return this.heslo;
	}

	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMeno() {
		return this.meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public String getPriezvisko() {
		return this.priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public List<ZamMaerz> getZamMaerzs() {
		return this.zamMaerzs;
	}

	public void setZamMaerzs(List<ZamMaerz> zamMaerzs) {
		this.zamMaerzs = zamMaerzs;
	}

	public ZamMaerz addZamMaerz(ZamMaerz zamMaerz) {
		getZamMaerzs().add(zamMaerz);
		zamMaerz.setZamestnanec(this);

		return zamMaerz;
	}

	public ZamMaerz removeZamMaerz(ZamMaerz zamMaerz) {
		getZamMaerzs().remove(zamMaerz);
		zamMaerz.setZamestnanec(null);

		return zamMaerz;
	}

	public Rola getRolaBean() {
		return this.rolaBean;
	}

	public void setRolaBean(Rola rolaBean) {
		this.rolaBean = rolaBean;
	}

}