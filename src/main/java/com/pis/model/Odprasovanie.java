package com.pis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the odprasovanie database table.
 * 
 */
@Entity
public class Odprasovanie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="herding_cas")
	private float herdingCas;

	@Column(name="herding_cistiace_impulzy")
	private String herdingCistiaceImpulzy;

	@Column(name="herding_chod_vyprazdnovacieho_zariadenia")
	private String herdingChodVyprazdnovaciehoZariadenia;

	private float m10_cas;

	@Temporal(TemporalType.DATE)
	private Date m10_datum_zmeny_hadic;

	private String m10_funkcnost_tesnost;

	private float m10_podtlak;

	private float m115_cas;

	private String m115_funkcnost_celistvost;

	private String m115_funkcnost_oklepavacieho_zariadenia;

	private String m115_chod_snekoveho_dopravnika;

	private float m116_cas;

	@Temporal(TemporalType.DATE)
	private Date m116_datum_zmeny_hadic;

	private String m116_funkcnost_tesnost;

	private float m116_podtlak;

	private float m117_cas;

	@Temporal(TemporalType.DATE)
	private Date m117_datum_zmeny_hadic;

	private String m117_funkcnost_tesnost;

	private float m117_podtlak;

	private float m12_cas;

	@Temporal(TemporalType.DATE)
	private Date m12_datum_zmeny_hadic;

	private String m12_funkcnost_tesnost;

	private float m12_podtlak;

	@Column(name="scheuch_cas")
	private float scheuchCas;

	@Column(name="scheuch_membranove_ventily")
	private String scheuchMembranoveVentily;

	@Column(name="scheuch_podtlak")
	private float scheuchPodtlak;

	@Column(name="scheuch_sneky")
	private String scheuchSneky;

	//bi-directional many-to-one association to Maerz
	@ManyToOne
	@JoinColumn(name="id_maerz")
	private Maerz maerz;

	public Odprasovanie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getHerdingCas() {
		return this.herdingCas;
	}

	public void setHerdingCas(float herdingCas) {
		this.herdingCas = herdingCas;
	}

	public String getHerdingCistiaceImpulzy() {
		return this.herdingCistiaceImpulzy;
	}

	public void setHerdingCistiaceImpulzy(String herdingCistiaceImpulzy) {
		this.herdingCistiaceImpulzy = herdingCistiaceImpulzy;
	}

	public String getHerdingChodVyprazdnovaciehoZariadenia() {
		return this.herdingChodVyprazdnovaciehoZariadenia;
	}

	public void setHerdingChodVyprazdnovaciehoZariadenia(String herdingChodVyprazdnovaciehoZariadenia) {
		this.herdingChodVyprazdnovaciehoZariadenia = herdingChodVyprazdnovaciehoZariadenia;
	}

	public float getM10_cas() {
		return this.m10_cas;
	}

	public void setM10_cas(float m10_cas) {
		this.m10_cas = m10_cas;
	}

	public Date getM10_datum_zmeny_hadic() {
		return this.m10_datum_zmeny_hadic;
	}

	public void setM10_datum_zmeny_hadic(Date m10_datum_zmeny_hadic) {
		this.m10_datum_zmeny_hadic = m10_datum_zmeny_hadic;
	}

	public String getM10_funkcnost_tesnost() {
		return this.m10_funkcnost_tesnost;
	}

	public void setM10_funkcnost_tesnost(String m10_funkcnost_tesnost) {
		this.m10_funkcnost_tesnost = m10_funkcnost_tesnost;
	}

	public float getM10_podtlak() {
		return this.m10_podtlak;
	}

	public void setM10_podtlak(float m10_podtlak) {
		this.m10_podtlak = m10_podtlak;
	}

	public float getM115_cas() {
		return this.m115_cas;
	}

	public void setM115_cas(float m115_cas) {
		this.m115_cas = m115_cas;
	}

	public String getM115_funkcnost_celistvost() {
		return this.m115_funkcnost_celistvost;
	}

	public void setM115_funkcnost_celistvost(String m115_funkcnost_celistvost) {
		this.m115_funkcnost_celistvost = m115_funkcnost_celistvost;
	}

	public String getM115_funkcnost_oklepavacieho_zariadenia() {
		return this.m115_funkcnost_oklepavacieho_zariadenia;
	}

	public void setM115_funkcnost_oklepavacieho_zariadenia(String m115_funkcnost_oklepavacieho_zariadenia) {
		this.m115_funkcnost_oklepavacieho_zariadenia = m115_funkcnost_oklepavacieho_zariadenia;
	}

	public String getM115_chod_snekoveho_dopravnika() {
		return this.m115_chod_snekoveho_dopravnika;
	}

	public void setM115_chod_snekoveho_dopravnika(String m115_chod_snekoveho_dopravnika) {
		this.m115_chod_snekoveho_dopravnika = m115_chod_snekoveho_dopravnika;
	}

	public float getM116_cas() {
		return this.m116_cas;
	}

	public void setM116_cas(float m116_cas) {
		this.m116_cas = m116_cas;
	}

	public Date getM116_datum_zmeny_hadic() {
		return this.m116_datum_zmeny_hadic;
	}

	public void setM116_datum_zmeny_hadic(Date m116_datum_zmeny_hadic) {
		this.m116_datum_zmeny_hadic = m116_datum_zmeny_hadic;
	}

	public String getM116_funkcnost_tesnost() {
		return this.m116_funkcnost_tesnost;
	}

	public void setM116_funkcnost_tesnost(String m116_funkcnost_tesnost) {
		this.m116_funkcnost_tesnost = m116_funkcnost_tesnost;
	}

	public float getM116_podtlak() {
		return this.m116_podtlak;
	}

	public void setM116_podtlak(float m116_podtlak) {
		this.m116_podtlak = m116_podtlak;
	}

	public float getM117_cas() {
		return this.m117_cas;
	}

	public void setM117_cas(float m117_cas) {
		this.m117_cas = m117_cas;
	}

	public Date getM117_datum_zmeny_hadic() {
		return this.m117_datum_zmeny_hadic;
	}

	public void setM117_datum_zmeny_hadic(Date m117_datum_zmeny_hadic) {
		this.m117_datum_zmeny_hadic = m117_datum_zmeny_hadic;
	}

	public String getM117_funkcnost_tesnost() {
		return this.m117_funkcnost_tesnost;
	}

	public void setM117_funkcnost_tesnost(String m117_funkcnost_tesnost) {
		this.m117_funkcnost_tesnost = m117_funkcnost_tesnost;
	}

	public float getM117_podtlak() {
		return this.m117_podtlak;
	}

	public void setM117_podtlak(float m117_podtlak) {
		this.m117_podtlak = m117_podtlak;
	}

	public float getM12_cas() {
		return this.m12_cas;
	}

	public void setM12_cas(float m12_cas) {
		this.m12_cas = m12_cas;
	}

	public Date getM12_datum_zmeny_hadic() {
		return this.m12_datum_zmeny_hadic;
	}

	public void setM12_datum_zmeny_hadic(Date m12_datum_zmeny_hadic) {
		this.m12_datum_zmeny_hadic = m12_datum_zmeny_hadic;
	}

	public String getM12_funkcnost_tesnost() {
		return this.m12_funkcnost_tesnost;
	}

	public void setM12_funkcnost_tesnost(String m12_funkcnost_tesnost) {
		this.m12_funkcnost_tesnost = m12_funkcnost_tesnost;
	}

	public float getM12_podtlak() {
		return this.m12_podtlak;
	}

	public void setM12_podtlak(float m12_podtlak) {
		this.m12_podtlak = m12_podtlak;
	}

	public float getScheuchCas() {
		return this.scheuchCas;
	}

	public void setScheuchCas(float scheuchCas) {
		this.scheuchCas = scheuchCas;
	}

	public String getScheuchMembranoveVentily() {
		return this.scheuchMembranoveVentily;
	}

	public void setScheuchMembranoveVentily(String scheuchMembranoveVentily) {
		this.scheuchMembranoveVentily = scheuchMembranoveVentily;
	}

	public float getScheuchPodtlak() {
		return this.scheuchPodtlak;
	}

	public void setScheuchPodtlak(float scheuchPodtlak) {
		this.scheuchPodtlak = scheuchPodtlak;
	}

	public String getScheuchSneky() {
		return this.scheuchSneky;
	}

	public void setScheuchSneky(String scheuchSneky) {
		this.scheuchSneky = scheuchSneky;
	}

	public Maerz getMaerz() {
		return this.maerz;
	}

	public void setMaerz(Maerz maerz) {
		this.maerz = maerz;
	}

}