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

	@Column(name="osobne_cislo")
	private int osobneCislo;

	private String priezvisko;

	//bi-directional many-to-one association to ZamMaerz
	@OneToMany(mappedBy="zamestnanec1")
	private List<ZamMaerz> zamMaerzs1;

	//bi-directional many-to-one association to ZamMaerz
	@OneToMany(mappedBy="zamestnanec2")
	private List<ZamMaerz> zamMaerzs2;

	//bi-directional many-to-one association to ZamMaerz
	@OneToMany(mappedBy="zamestnanec3")
	private List<ZamMaerz> zamMaerzs3;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="rola")
	private Rola rolaBean;

	public Zamestnanec() {
	}
	
	

	@Override
	public String toString() {
		return  meno +  priezvisko;
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

	public int getOsobneCislo() {
		return this.osobneCislo;
	}

	public void setOsobneCislo(int osobneCislo) {
		this.osobneCislo = osobneCislo;
	}

	public String getPriezvisko() {
		return this.priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public List<ZamMaerz> getZamMaerzs1() {
		return this.zamMaerzs1;
	}

	public void setZamMaerzs1(List<ZamMaerz> zamMaerzs1) {
		this.zamMaerzs1 = zamMaerzs1;
	}

	public ZamMaerz addZamMaerzs1(ZamMaerz zamMaerzs1) {
		getZamMaerzs1().add(zamMaerzs1);
		zamMaerzs1.setZamestnanec1(this);

		return zamMaerzs1;
	}

	public ZamMaerz removeZamMaerzs1(ZamMaerz zamMaerzs1) {
		getZamMaerzs1().remove(zamMaerzs1);
		zamMaerzs1.setZamestnanec1(null);

		return zamMaerzs1;
	}

	public List<ZamMaerz> getZamMaerzs2() {
		return this.zamMaerzs2;
	}

	public void setZamMaerzs2(List<ZamMaerz> zamMaerzs2) {
		this.zamMaerzs2 = zamMaerzs2;
	}

	public ZamMaerz addZamMaerzs2(ZamMaerz zamMaerzs2) {
		getZamMaerzs2().add(zamMaerzs2);
		zamMaerzs2.setZamestnanec2(this);

		return zamMaerzs2;
	}

	public ZamMaerz removeZamMaerzs2(ZamMaerz zamMaerzs2) {
		getZamMaerzs2().remove(zamMaerzs2);
		zamMaerzs2.setZamestnanec2(null);

		return zamMaerzs2;
	}

	public List<ZamMaerz> getZamMaerzs3() {
		return this.zamMaerzs3;
	}

	public void setZamMaerzs3(List<ZamMaerz> zamMaerzs3) {
		this.zamMaerzs3 = zamMaerzs3;
	}

	public ZamMaerz addZamMaerzs3(ZamMaerz zamMaerzs3) {
		getZamMaerzs3().add(zamMaerzs3);
		zamMaerzs3.setZamestnanec3(this);

		return zamMaerzs3;
	}

	public ZamMaerz removeZamMaerzs3(ZamMaerz zamMaerzs3) {
		getZamMaerzs3().remove(zamMaerzs3);
		zamMaerzs3.setZamestnanec3(null);

		return zamMaerzs3;
	}

	public Rola getRolaBean() {
		return this.rolaBean;
	}

	public void setRolaBean(Rola rolaBean) {
		this.rolaBean = rolaBean;
	}

}