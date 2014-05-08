package com.pis.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;


/**
 * The persistent class for the maerz database table.
 * 
 */
@Entity
public class Maerz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="briketizacka_kon_stav")
	private float briketizackaKonStav;

	@Column(name="briketizacka_poc_stav")
	private float briketizackaPocStav;

	private float filter_M20_kon_stav;

	private float filter_M20_poc_stav;

	@Column(name="chod_pece")
	private float chodPece;

	@Column(name="kontrola_ochrannych_krytov")
	private String kontrolaOchrannychKrytov;

	@Column(name="neodstranene_poruchy")
	private String neodstranenePoruchy;

	@Column(name="pracovna_snimka_strojnik")
	private String pracovnaSnimkaStrojnik;

	@Column(name="pracovna_snimka_velinar")
	private String pracovnaSnimkaVelinar;

	@Column(name="stav_izolatorov_ventilatorov")
	private String stavIzolatorovVentilatorov;

	@Column(name="stav_lekarnicky")
	private String stavLekarnicky;

	@Column(name="stav_obeznych_kolies_ventilatorov")
	private String stavObeznychKoliesVentilatorov;

	@Column(name="stav_potrubia_vzduchotechniky")
	private String stavPotrubiaVzduchotechniky;

	@Column(name="teplota_pyrometra")
	private String teplotaPyrometra;

	@Column(name="vstup_tepla")
	private String vstupTepla;

	@Column(name="vyroba_vapenec_vsadzka_17_frakcia_vapenca")
	private String vyrobaVapenecVsadzka17FrakciaVapenca;

	@Column(name="vyroba_vapenec_vsadzka_17_skut")
	private float vyrobaVapenecVsadzka17Skut;

	@Column(name="vyroba_vapenec_vsadzka_35_frakcia_vapenca")
	private String vyrobaVapenecVsadzka35FrakciaVapenca;

	@Column(name="vyroba_vapenec_vsadzka_35_skut")
	private float vyrobaVapenecVsadzka35Skut;

	@Column(name="vyroba_vapenec_vsadzka_6_frakcia_vapenca")
	private String vyrobaVapenecVsadzka6FrakciaVapenca;

	@Column(name="vyroba_vapenec_vsadzka_6_skut")
	private float vyrobaVapenecVsadzka6Skut;

	@Column(name="vyroba_vapno_17_plan")
	private float vyrobaVapno17Plan;

	@Column(name="vyroba_vapno_17_skut")
	private float vyrobaVapno17Skut;

	@Column(name="vyroba_vapno_35_plan")
	private float vyrobaVapno35Plan;

	@Column(name="vyroba_vapno_35_skut")
	private float vyrobaVapno35Skut;

	@Column(name="vyroba_vapno_6_plan")
	private float vyrobaVapno6Plan;

	@Column(name="vyroba_vapno_6_skut")
	private float vyrobaVapno6Skut;

	@Column(name="vysledok_kontroly_technologickeho_zariadenia")
	private String vysledokKontrolyTechnologickehoZariadenia;

	@Column(name="zasobnik_1_druh")
	private int zasobnik1Druh;

	@Column(name="zasobnik_1_plnenie")
	private int zasobnik1Plnenie;

	@Column(name="zasobnik_2_druh")
	private int zasobnik2Druh;

	@Column(name="zasobnik_2_plnenie")
	private int zasobnik2Plnenie;

	@Column(name="zasobnik_5_druh")
	private int zasobnik5Druh;

	@Column(name="zasobnik_5_plnenie")
	private int zasobnik5Plnenie;

	@Column(name="zasobnik_nova_lanovka_druh")
	private int zasobnikNovaLanovkaDruh;

	@Column(name="zasobnik_nova_lanovka_plnenie")
	private int zasobnikNovaLanovkaPlnenie;

	//bi-directional many-to-one association to Odprasovanie
	@OneToMany(mappedBy="maerz")
	private List<Odprasovanie> odprasovanies;

	//bi-directional many-to-one association to ZamMaerz
	@OneToMany(mappedBy="maerz")
	private List<ZamMaerz> zamMaerzs;

	public Maerz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBriketizackaKonStav() {
		return this.briketizackaKonStav;
	}

	public void setBriketizackaKonStav(float briketizackaKonStav) {
		this.briketizackaKonStav = briketizackaKonStav;
	}

	public float getBriketizackaPocStav() {
		return this.briketizackaPocStav;
	}

	public void setBriketizackaPocStav(float briketizackaPocStav) {
		this.briketizackaPocStav = briketizackaPocStav;
	}

	public float getFilter_M20_kon_stav() {
		return this.filter_M20_kon_stav;
	}

	public void setFilter_M20_kon_stav(float filter_M20_kon_stav) {
		this.filter_M20_kon_stav = filter_M20_kon_stav;
	}

	public float getFilter_M20_poc_stav() {
		return this.filter_M20_poc_stav;
	}

	public void setFilter_M20_poc_stav(float filter_M20_poc_stav) {
		this.filter_M20_poc_stav = filter_M20_poc_stav;
	}

	public float getChodPece() {
		return this.chodPece;
	}

	public void setChodPece(float chodPece) {
		this.chodPece = chodPece;
	}

	public String getKontrolaOchrannychKrytov() {
		return this.kontrolaOchrannychKrytov;
	}

	public void setKontrolaOchrannychKrytov(String kontrolaOchrannychKrytov) {
		this.kontrolaOchrannychKrytov = kontrolaOchrannychKrytov;
	}

	public String getNeodstranenePoruchy() {
		return this.neodstranenePoruchy;
	}

	public void setNeodstranenePoruchy(String neodstranenePoruchy) {
		this.neodstranenePoruchy = neodstranenePoruchy;
	}

	public String getPracovnaSnimkaStrojnik() {
		return this.pracovnaSnimkaStrojnik;
	}

	public void setPracovnaSnimkaStrojnik(String pracovnaSnimkaStrojnik) {
		this.pracovnaSnimkaStrojnik = pracovnaSnimkaStrojnik;
	}

	public String getPracovnaSnimkaVelinar() {
		return this.pracovnaSnimkaVelinar;
	}

	public void setPracovnaSnimkaVelinar(String pracovnaSnimkaVelinar) {
		this.pracovnaSnimkaVelinar = pracovnaSnimkaVelinar;
	}

	public String getStavIzolatorovVentilatorov() {
		return this.stavIzolatorovVentilatorov;
	}

	public void setStavIzolatorovVentilatorov(String stavIzolatorovVentilatorov) {
		this.stavIzolatorovVentilatorov = stavIzolatorovVentilatorov;
	}

	public String getStavLekarnicky() {
		return this.stavLekarnicky;
	}

	public void setStavLekarnicky(String stavLekarnicky) {
		this.stavLekarnicky = stavLekarnicky;
	}

	public String getStavObeznychKoliesVentilatorov() {
		return this.stavObeznychKoliesVentilatorov;
	}

	public void setStavObeznychKoliesVentilatorov(String stavObeznychKoliesVentilatorov) {
		this.stavObeznychKoliesVentilatorov = stavObeznychKoliesVentilatorov;
	}

	public String getStavPotrubiaVzduchotechniky() {
		return this.stavPotrubiaVzduchotechniky;
	}

	public void setStavPotrubiaVzduchotechniky(String stavPotrubiaVzduchotechniky) {
		this.stavPotrubiaVzduchotechniky = stavPotrubiaVzduchotechniky;
	}

	public String getTeplotaPyrometra() {
		return this.teplotaPyrometra;
	}

	public void setTeplotaPyrometra(String teplotaPyrometra) {
		this.teplotaPyrometra = teplotaPyrometra;
	}

	public String getVstupTepla() {
		return this.vstupTepla;
	}

	public void setVstupTepla(String vstupTepla) {
		this.vstupTepla = vstupTepla;
	}

	public String getVyrobaVapenecVsadzka17FrakciaVapenca() {
		return this.vyrobaVapenecVsadzka17FrakciaVapenca;
	}

	public void setVyrobaVapenecVsadzka17FrakciaVapenca(String vyrobaVapenecVsadzka17FrakciaVapenca) {
		this.vyrobaVapenecVsadzka17FrakciaVapenca = vyrobaVapenecVsadzka17FrakciaVapenca;
	}

	public float getVyrobaVapenecVsadzka17Skut() {
		return this.vyrobaVapenecVsadzka17Skut;
	}

	public void setVyrobaVapenecVsadzka17Skut(float vyrobaVapenecVsadzka17Skut) {
		this.vyrobaVapenecVsadzka17Skut = vyrobaVapenecVsadzka17Skut;
	}

	public String getVyrobaVapenecVsadzka35FrakciaVapenca() {
		return this.vyrobaVapenecVsadzka35FrakciaVapenca;
	}

	public void setVyrobaVapenecVsadzka35FrakciaVapenca(String vyrobaVapenecVsadzka35FrakciaVapenca) {
		this.vyrobaVapenecVsadzka35FrakciaVapenca = vyrobaVapenecVsadzka35FrakciaVapenca;
	}

	public float getVyrobaVapenecVsadzka35Skut() {
		return this.vyrobaVapenecVsadzka35Skut;
	}

	public void setVyrobaVapenecVsadzka35Skut(float vyrobaVapenecVsadzka35Skut) {
		this.vyrobaVapenecVsadzka35Skut = vyrobaVapenecVsadzka35Skut;
	}

	public String getVyrobaVapenecVsadzka6FrakciaVapenca() {
		return this.vyrobaVapenecVsadzka6FrakciaVapenca;
	}

	public void setVyrobaVapenecVsadzka6FrakciaVapenca(String vyrobaVapenecVsadzka6FrakciaVapenca) {
		this.vyrobaVapenecVsadzka6FrakciaVapenca = vyrobaVapenecVsadzka6FrakciaVapenca;
	}

	public float getVyrobaVapenecVsadzka6Skut() {
		return this.vyrobaVapenecVsadzka6Skut;
	}

	public void setVyrobaVapenecVsadzka6Skut(float vyrobaVapenecVsadzka6Skut) {
		this.vyrobaVapenecVsadzka6Skut = vyrobaVapenecVsadzka6Skut;
	}

	public float getVyrobaVapno17Plan() {
		return this.vyrobaVapno17Plan;
	}

	public void setVyrobaVapno17Plan(float vyrobaVapno17Plan) {
		this.vyrobaVapno17Plan = vyrobaVapno17Plan;
	}

	public float getVyrobaVapno17Skut() {
		return this.vyrobaVapno17Skut;
	}

	public void setVyrobaVapno17Skut(float vyrobaVapno17Skut) {
		this.vyrobaVapno17Skut = vyrobaVapno17Skut;
	}

	public float getVyrobaVapno35Plan() {
		return this.vyrobaVapno35Plan;
	}

	public void setVyrobaVapno35Plan(float vyrobaVapno35Plan) {
		this.vyrobaVapno35Plan = vyrobaVapno35Plan;
	}

	public float getVyrobaVapno35Skut() {
		return this.vyrobaVapno35Skut;
	}

	public void setVyrobaVapno35Skut(float vyrobaVapno35Skut) {
		this.vyrobaVapno35Skut = vyrobaVapno35Skut;
	}

	public float getVyrobaVapno6Plan() {
		return this.vyrobaVapno6Plan;
	}

	public void setVyrobaVapno6Plan(float vyrobaVapno6Plan) {
		this.vyrobaVapno6Plan = vyrobaVapno6Plan;
	}

	public float getVyrobaVapno6Skut() {
		return this.vyrobaVapno6Skut;
	}

	public void setVyrobaVapno6Skut(float vyrobaVapno6Skut) {
		this.vyrobaVapno6Skut = vyrobaVapno6Skut;
	}

	public String getVysledokKontrolyTechnologickehoZariadenia() {
		return this.vysledokKontrolyTechnologickehoZariadenia;
	}

	public void setVysledokKontrolyTechnologickehoZariadenia(String vysledokKontrolyTechnologickehoZariadenia) {
		this.vysledokKontrolyTechnologickehoZariadenia = vysledokKontrolyTechnologickehoZariadenia;
	}

	public int getZasobnik1Druh() {
		return this.zasobnik1Druh;
	}

	public void setZasobnik1Druh(int zasobnik1Druh) {
		this.zasobnik1Druh = zasobnik1Druh;
	}

	public int getZasobnik1Plnenie() {
		return this.zasobnik1Plnenie;
	}

	public void setZasobnik1Plnenie(int zasobnik1Plnenie) {
		this.zasobnik1Plnenie = zasobnik1Plnenie;
	}

	public int getZasobnik2Druh() {
		return this.zasobnik2Druh;
	}

	public void setZasobnik2Druh(int zasobnik2Druh) {
		this.zasobnik2Druh = zasobnik2Druh;
	}

	public int getZasobnik2Plnenie() {
		return this.zasobnik2Plnenie;
	}

	public void setZasobnik2Plnenie(int zasobnik2Plnenie) {
		this.zasobnik2Plnenie = zasobnik2Plnenie;
	}

	public int getZasobnik5Druh() {
		return this.zasobnik5Druh;
	}

	public void setZasobnik5Druh(int zasobnik5Druh) {
		this.zasobnik5Druh = zasobnik5Druh;
	}

	public int getZasobnik5Plnenie() {
		return this.zasobnik5Plnenie;
	}

	public void setZasobnik5Plnenie(int zasobnik5Plnenie) {
		this.zasobnik5Plnenie = zasobnik5Plnenie;
	}

	public int getZasobnikNovaLanovkaDruh() {
		return this.zasobnikNovaLanovkaDruh;
	}

	public void setZasobnikNovaLanovkaDruh(int zasobnikNovaLanovkaDruh) {
		this.zasobnikNovaLanovkaDruh = zasobnikNovaLanovkaDruh;
	}

	public int getZasobnikNovaLanovkaPlnenie() {
		return this.zasobnikNovaLanovkaPlnenie;
	}

	public void setZasobnikNovaLanovkaPlnenie(int zasobnikNovaLanovkaPlnenie) {
		this.zasobnikNovaLanovkaPlnenie = zasobnikNovaLanovkaPlnenie;
	}

	public List<Odprasovanie> getOdprasovanies() {
		return this.odprasovanies;
	}

	public void setOdprasovanies(List<Odprasovanie> odprasovanies) {
		this.odprasovanies = odprasovanies;
	}

	public Odprasovanie addOdprasovany(Odprasovanie odprasovany) {
		getOdprasovanies().add(odprasovany);
		odprasovany.setMaerz(this);

		return odprasovany;
	}

	public Odprasovanie removeOdprasovany(Odprasovanie odprasovany) {
		getOdprasovanies().remove(odprasovany);
		odprasovany.setMaerz(null);

		return odprasovany;
	}

	public List<ZamMaerz> getZamMaerzs() {
		return this.zamMaerzs;
	}

	public void setZamMaerzs(List<ZamMaerz> zamMaerzs) {
		this.zamMaerzs = zamMaerzs;
	}

	public ZamMaerz addZamMaerz(ZamMaerz zamMaerz) {
		getZamMaerzs().add(zamMaerz);
		zamMaerz.setMaerz(this);

		return zamMaerz;
	}

	public ZamMaerz removeZamMaerz(ZamMaerz zamMaerz) {
		getZamMaerzs().remove(zamMaerz);
		zamMaerz.setMaerz(null);

		return zamMaerz;
	}

}