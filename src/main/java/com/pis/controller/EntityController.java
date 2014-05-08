package com.pis.controller;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pis.formular.Formular;
import com.pis.formular.FormularVeduci;
import com.pis.model.Maerz;
import com.pis.model.Odprasovanie;
import com.pis.model.ZamMaerz;
import com.pis.model.Zamestnanec;
import com.pis.service.EntityService;
import com.pis.service.MaerzService;
import com.pis.service.MaerzServiceImpl;

@Controller
@RequestMapping(value = "/")
public class EntityController extends WebMvcConfigurerAdapter {

	/*
	 * @Autowired private EntityService<Rola> rolaService;
	 */
	@Autowired
	private MaerzService maerzServiceImpl;
	// private MaerzServiceImpl maerzServiceImpl;
	@Autowired
	private EntityService<ZamMaerz> zamMaerzService;
	@Autowired
	private EntityService<Zamestnanec> zamestnanecService;
	@Autowired
	private EntityService<Odprasovanie> odprasovanieService;

	// formular
	private Formular formular;
	private FormularVeduci formularVeduci;
	private List<Zamestnanec> majsterList;
	private List<Zamestnanec> velinarList;
	private List<Zamestnanec> strojnikList;

	// pomocne
	private String message = "Maerz bol úspešne pridaný.";
	private Boolean prvaZmena = false;
	private Boolean druhaZmena = false;
	private Boolean vytvor = false;
	private int maerzLastId = 1;
	private int zamMaerzLastId = 1;
	private int odprasovanieLastId = 1;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		webDataBinder.registerCustomEditor(Zamestnanec.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String text) {
				Zamestnanec zam = zamestnanecService.getEntity(Integer.parseInt(text));
				setValue(zam);
			}
		});
	}

	@RequestMapping(value = "/synchStrojnik", method = RequestMethod.GET)
	public ModelAndView synchStrojnik() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/synchMajster", method = RequestMethod.GET)
	public ModelAndView synchMajster() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/synchVeduci", method = RequestMethod.GET)
	public ModelAndView synchVeduci() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-veduci");
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("formularVeduci",formularVeduci);
		return modelAndView;
	}

	@RequestMapping(value = "/synchVelinar", method = RequestMethod.GET)
	public ModelAndView synchVelinar() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		modelAndView = setModelAndViewVelinar(modelAndView);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-strojnik", method = RequestMethod.GET)
	public ModelAndView addMaerzPageStrojnik() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		nastavZmenu();
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId() + 1;
			formular.setMaerz(new Maerz());
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId();
			formular.setMaerz(maerzServiceImpl.getEntity(maerzLastId));
		}
		nastavDatumAZmena();
		// MODEL AND VIEW
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-strojnik", method = RequestMethod.POST)
	public ModelAndView addingMaerzStrojnik(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		form.getMaerz().setId(maerzLastId);
		// formular = Formular.getInstance();
		if (vytvor == true) {
			maerzServiceImpl.add(form.getMaerz());
			vytvor = false;
		} else {
			maerzServiceImpl.updateStrojnik(form.getMaerz());
		}
		formular.setMaerz(maerzServiceImpl.getEntity(maerzLastId));

		// MODEL AND VIEW
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("message", message);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	// ---------------------------------------------------------------- VELINAR
	// ---------------------------------

	@RequestMapping(value = "/add-maerz-form-velinar", method = RequestMethod.GET)
	public ModelAndView addMaerzPageVelinar(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		nastavZmenu();
		majsterList = new ArrayList<Zamestnanec>();
		majsterList = zamestnanecService.getAllMajster();
		majsterList.add(zamestnanecService.getEntity(11));
		velinarList = new ArrayList<Zamestnanec>();
		velinarList = zamestnanecService.getAllVelinar();
		velinarList.add(zamestnanecService.getEntity(11));
		strojnikList = new ArrayList<Zamestnanec>();
		strojnikList = zamestnanecService.getAllStrojnik();
		strojnikList.add(zamestnanecService.getEntity(11));
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId() + 1;
			zamMaerzLastId = zamMaerzService.getLastId() + 1;
			odprasovanieLastId = odprasovanieService.getLastId() + 1;
			formular.setMaerz(new Maerz());
			formular.setZamMaerz(new ZamMaerz());
			formular.setOdprasovanie(new Odprasovanie());
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId();
			zamMaerzLastId = zamMaerzService.getLastId();
			odprasovanieLastId = odprasovanieService.getLastId();
			formular.setMaerz(maerzServiceImpl.getEntity(maerzLastId));
			formular.setZamMaerz(zamMaerzService.getEntity(zamMaerzLastId));
			formular.setOdprasovanie(odprasovanieService.getEntity(odprasovanieLastId));

			if (formular.getZamMaerz().getZamestnanec2() == null)
				majsterList.add(0, zamestnanecService.getEntity(11));
			else
				majsterList.add(0, formular.getZamMaerz().getZamestnanec2());

			if (formular.getZamMaerz().getZamestnanec1() == null)
				velinarList.add(0, zamestnanecService.getEntity(11));
			else
				velinarList.add(0, formular.getZamMaerz().getZamestnanec1());

			if (formular.getZamMaerz().getZamestnanec3() == null)
				strojnikList.add(0, zamestnanecService.getEntity(11));
			else
				strojnikList.add(0, formular.getZamMaerz().getZamestnanec3());
		}
		// NASTAVENIE PREMENNYCH FORMULARA
		nastavDatumAZmena();
		// MODEL AND VIEW
		modelAndView = setModelAndViewVelinar(modelAndView);
		modelAndView.addObject("formular", formular);
		return modelAndView;

	}

	@RequestMapping(value = "/add-maerz-form-velinar", method = RequestMethod.POST)
	public ModelAndView addingMaerzVelinar(@ModelAttribute @Valid Formular form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		if (bindingResult.hasErrors()) {
			// NASTAVENIE PREMENNYCH FORMULARA
			nastavDatumAZmena();
			// MODEL AND VIEW
			modelAndView = setModelAndViewVelinar(modelAndView);
			modelAndView.addObject("message", "chyba");
			return modelAndView;
		}

		// MAERZ
		form.getMaerz().setId(maerzLastId);
		// ZAM_MAERZ
		ZamMaerz zamMaerz = new ZamMaerz();
		zamMaerz.setId(zamMaerzLastId);
		zamMaerz.setMaerz(form.getMaerz());
		if (form.getZamMaerz().getZamestnanec1().getMeno().equals("nikto")) {
			zamMaerz.setZamestnanec1(null);
			velinarList.add(0, zamestnanecService.getEntity(11));
		} else {
			zamMaerz.setZamestnanec1(form.getZamMaerz().getZamestnanec1());
			velinarList.remove(0);
			velinarList.add(0, form.getZamMaerz().getZamestnanec1());
		}

		if (form.getZamMaerz().getZamestnanec2().getMeno().equals("nikto")) {
			zamMaerz.setZamestnanec2(null);
			majsterList.add(0, zamestnanecService.getEntity(11));
		} else {
			zamMaerz.setZamestnanec2(form.getZamMaerz().getZamestnanec2());
			majsterList.remove(0);
			majsterList.add(0, form.getZamMaerz().getZamestnanec2());
		}
		if (form.getZamMaerz().getZamestnanec3().getMeno().equals("nikto")) {
			zamMaerz.setZamestnanec3(null);
			strojnikList.add(0, zamestnanecService.getEntity(11));
		} else {
			zamMaerz.setZamestnanec3(form.getZamMaerz().getZamestnanec3());
			strojnikList.remove(0);
			strojnikList.add(0, form.getZamMaerz().getZamestnanec3());
		}
		zamMaerz.setDatum(new Date());
		zamMaerz.setZmena(formular.getZmena());
		if (vytvor == true) {
			// MAERZ
			maerzServiceImpl.add(form.getMaerz());
			// ZAM_MAERZ
			zamMaerzService.add(zamMaerz);
			vytvor = false;
		} else {
			// MAERZ
			maerzServiceImpl.updateVelinar(form.getMaerz());
			// ZAM_MAERZ
			zamMaerzService.update(zamMaerz);
		}
		formular.setMaerz(maerzServiceImpl.getEntity(maerzLastId));
		formular.setZamMaerz(form.getZamMaerz());

		// MODEL AND VIEW
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("message", message);
		modelAndView = setModelAndViewVelinar(modelAndView);
		return modelAndView;
	}

	// --------------------------------------------------------------- VEDUCI
	// --------------------------------------------------
	@RequestMapping(value = "/add-maerz-form-veduci", method = RequestMethod.GET)
	public ModelAndView addingMaerzPageVeduci(@ModelAttribute FormularVeduci formVeduci) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-veduci");
		nastavZmenu();
		formularVeduci = new FormularVeduci();
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId() + 1;
			formular.setMaerz(new Maerz());
			formular.setZamMaerz(new ZamMaerz());
			formular.setOdprasovanie(new Odprasovanie());
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId();
			zamMaerzLastId = zamMaerzService.getLastId();
			odprasovanieLastId = odprasovanieService.getLastId();
			formular.setMaerz(maerzServiceImpl.getEntity(maerzLastId));
			formular.setZamMaerz(zamMaerzService.getEntity(zamMaerzLastId));
			formular.setOdprasovanie(odprasovanieService.getEntity(odprasovanieLastId));
			System.out.println(formular.getMaerz().getVyrobaVapno6Plan());
			formularVeduci.setVyrobaVapno6Plan(formular.getMaerz().getVyrobaVapno6Plan());
			formularVeduci.setVyrobaVapno17Plan(formular.getMaerz().getVyrobaVapno17Plan());
			formularVeduci.setVyrobaVapno35Plan(formular.getMaerz().getVyrobaVapno35Plan());
		}
		nastavDatumAZmena();
		// MODEL AND VIEW
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("formularVeduci", formularVeduci);
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-maerz-form-veduci", method = RequestMethod.POST)
	public ModelAndView addingMaerzVeduci(@ModelAttribute @Valid FormularVeduci formVeduci, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-veduci");
		if (bindingResult.hasErrors()) {
			// NASTAVENIE PREMENNYCH FORMULARA
			nastavDatumAZmena();
			// MODEL AND VIEW
			modelAndView.addObject("formular", formular);
			modelAndView.addObject("message", "chyba");
			return modelAndView;
		}
		formular.getMaerz().setVyrobaVapno6Plan(formVeduci.getVyrobaVapno6Plan());
		formular.getMaerz().setVyrobaVapno17Plan(formVeduci.getVyrobaVapno17Plan());
		formular.getMaerz().setVyrobaVapno35Plan(formVeduci.getVyrobaVapno35Plan());
		maerzServiceImpl.updateVeduci(formular.getMaerz());
		//MODEL AND VIEW
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("formularVeduci", formVeduci);
		modelAndView.addObject("message", "maerz uspesne pridany");
		return modelAndView;
	}

	// ---------------------------------------------------------------------------
	// MAJSTER

	@RequestMapping(value = "/add-maerz-form-majster", method = RequestMethod.GET)
	public ModelAndView addMaerzPageMajster() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		nastavZmenu();

		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId() + 1;
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzServiceImpl.getLastId();
			formular.setMaerz(maerzServiceImpl.getEntity(maerzLastId));
		}
		nastavDatumAZmena();
		// MODEL AND VIEW
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	public void nastavZmenu() {
		Calendar calendar = Calendar.getInstance();
		Calendar zacZmeny = Calendar.getInstance();
		Calendar konZmeny = Calendar.getInstance();
		zacZmeny.set(Calendar.HOUR_OF_DAY, 6);
		zacZmeny.set(Calendar.MINUTE, 0);
		zacZmeny.set(Calendar.SECOND, 0);
		konZmeny.set(Calendar.HOUR_OF_DAY, 18);
		konZmeny.set(Calendar.MINUTE, 0);
		konZmeny.set(Calendar.SECOND, 0);
		if (calendar.after(zacZmeny) && calendar.before(konZmeny)) {
			
			prvaZmena = true;
		} else {
			druhaZmena = true;
		}
	}

	public Boolean jeNovaZmena() {
		Calendar calendar = Calendar.getInstance();
		Calendar zacZmeny = Calendar.getInstance();
		Calendar konZmeny = Calendar.getInstance();
		zacZmeny.set(Calendar.HOUR_OF_DAY, 6);
		zacZmeny.set(Calendar.MINUTE, 0);
		zacZmeny.set(Calendar.SECOND, 0);
		konZmeny.set(Calendar.HOUR_OF_DAY, 18);
		konZmeny.set(Calendar.MINUTE, 0);
		konZmeny.set(Calendar.SECOND, 0);
		if (calendar.after(zacZmeny) && calendar.before(konZmeny) && prvaZmena == true && druhaZmena == false) {
			return false;
		} else if (calendar.after(zacZmeny) && calendar.before(konZmeny) && prvaZmena == true && druhaZmena == true) {
			druhaZmena = false;
			return true;
		} else if (prvaZmena == true && druhaZmena == true) {
			prvaZmena = false;
			return true;
		} else {
			return false;
		}
	}

	public void nastavDatumAZmena() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String date = sdf.format(new Date());
		formular.setDatum(date);
		if (prvaZmena == true)
			formular.setZmena(1);
		else if (druhaZmena == true)
			formular.setZmena(2);
	}

	public ModelAndView vzorce(ModelAndView model) {
		DecimalFormat d = new DecimalFormat("#.##");
		model.addObject("D16", Integer.toString(formular.getMaerz().getZasobnik1Plnenie() * 2));
		model.addObject("D17", Integer.toString(formular.getMaerz().getZasobnik2Plnenie() * 2));
		model.addObject("D18", Integer.toString(formular.getMaerz().getZasobnik5Plnenie() * 35 / 100));
		model.addObject("E23", d.format(formular.getMaerz().getVyrobaVapno6Skut() * 0.4));
		model.addObject("F23", d.format(formular.getMaerz().getVyrobaVapno6Skut() * 0.6));
		model.addObject("G23", Integer.toString(maerzServiceImpl.getG23(1)));
		model.addObject("E24", d.format(formular.getMaerz().getVyrobaVapno17Skut() * 0.4));
		model.addObject("F24", d.format(formular.getMaerz().getVyrobaVapno17Skut() * 0.6));
		model.addObject("G24", "0");
		model.addObject("E25", d.format(formular.getMaerz().getVyrobaVapno35Skut() * 0.4));
		model.addObject("F25", d.format(formular.getMaerz().getVyrobaVapno35Skut() * 0.6));
		model.addObject("G25", "0");
		Float B26 = formular.getMaerz().getVyrobaVapno6Plan() + formular.getMaerz().getVyrobaVapno17Plan() + formular.getMaerz().getVyrobaVapno35Plan();
		model.addObject("B26", d.format(B26));
		Float C26 = formular.getMaerz().getVyrobaVapno6Skut() + formular.getMaerz().getVyrobaVapno17Skut() + formular.getMaerz().getVyrobaVapno35Skut();
		model.addObject("C26", d.format(C26));
		model.addObject("D26", d.format(C26 / B26 * 100));
		model.addObject("G26", "0");
		model.addObject("B29", d.format(formular.getMaerz().getVyrobaVapno6Plan() / 0.552));
		model.addObject("B30", d.format(formular.getMaerz().getVyrobaVapno17Plan() / 0.552));
		model.addObject("B31", d.format(formular.getMaerz().getVyrobaVapno35Plan() / 0.552));
		model.addObject("C32", d.format(formular.getMaerz().getVyrobaVapenecVsadzka6Skut() + formular.getMaerz().getVyrobaVapenecVsadzka17Skut() + formular.getMaerz().getVyrobaVapenecVsadzka35Skut()));
		model.addObject("F35", d.format(formular.getMaerz().getBriketizackaKonStav() - formular.getMaerz().getBriketizackaPocStav()));
		model.addObject("G35", d.format(formular.getMaerz().getFilter_M20_kon_stav() - formular.getMaerz().getFilter_M20_poc_stav()));
		model.addObject("B36", d.format(12 - formular.getMaerz().getChodPece()));
		model.addObject("F36", "0");
		model.addObject("G36", "0");
		return model;
	}

	public ModelAndView setModelAndViewVelinar(ModelAndView modelAndView) {
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("majsterList", majsterList);
		modelAndView.addObject("velinarList", velinarList);
		modelAndView.addObject("strojnikList", strojnikList);
		modelAndView.addObject("neodstranenePoruchy", formular.getMaerz().getNeodstranenePoruchy());
		modelAndView.addObject("datum", formular.getDatum());
		modelAndView.addObject("zmena", formular.getZmena());
		modelAndView.addObject("vyrobaVapno6Plan", formular.getMaerz().getVyrobaVapno6Plan());
		modelAndView.addObject("vyrobaVapno17Plan", formular.getMaerz().getVyrobaVapno17Plan());
		modelAndView.addObject("vyrobaVapno35Plan", formular.getMaerz().getVyrobaVapno35Plan());
		modelAndView.addObject("kontrolaOchrannychKrytov", formular.getMaerz().getKontrolaOchrannychKrytov());
		modelAndView.addObject("stavPotrubiaVzduchotechniky", formular.getMaerz().getStavPotrubiaVzduchotechniky());
		modelAndView.addObject("stavObeznychKoliesVentilatorov", formular.getMaerz().getStavObeznychKoliesVentilatorov());
		modelAndView.addObject("stavIzolatorovVentilatorov", formular.getMaerz().getStavIzolatorovVentilatorov());
		modelAndView.addObject("vysledokKontrolyTechnologickehoZariadenia", formular.getMaerz().getVysledokKontrolyTechnologickehoZariadenia());
		modelAndView.addObject("pracovnaSnimkaStrojnik", formular.getMaerz().getPracovnaSnimkaStrojnik());
		modelAndView.addObject("scheuchCas", formular.getOdprasovanie().getScheuchCas());
		modelAndView.addObject("m10_cas", formular.getOdprasovanie().getM10_cas());
		modelAndView.addObject("scheuchMembranoveVentily", formular.getOdprasovanie().getScheuchMembranoveVentily());
		modelAndView.addObject("m10_podtlak", formular.getOdprasovanie().getM10_podtlak());
		modelAndView.addObject("scheuchSneky", formular.getOdprasovanie().getScheuchSneky());
		modelAndView.addObject("m10_datum_zmeny_hadic", formular.getOdprasovanie().getM10_datum_zmeny_hadic());
		modelAndView.addObject("scheuchPodtlak", formular.getOdprasovanie().getScheuchPodtlak());
		modelAndView.addObject("m10_funkcnost_tesnost", formular.getOdprasovanie().getM10_funkcnost_tesnost());
		modelAndView.addObject("m117_cas", formular.getOdprasovanie().getM117_cas());
		modelAndView.addObject("m116_cas", formular.getOdprasovanie().getM116_cas());
		modelAndView.addObject("m117_podtlak", formular.getOdprasovanie().getM117_podtlak());
		modelAndView.addObject("m116_podtlak", formular.getOdprasovanie().getM116_podtlak());
		modelAndView.addObject("m117_datum_zmeny_hadic", formular.getOdprasovanie().getM117_datum_zmeny_hadic());
		modelAndView.addObject("m116_datum_zmeny_hadic", formular.getOdprasovanie().getM116_datum_zmeny_hadic());
		modelAndView.addObject("m117_funkcnost_tesnost", formular.getOdprasovanie().getM117_funkcnost_tesnost());
		modelAndView.addObject("m116_funkcnost_tesnost", formular.getOdprasovanie().getM116_funkcnost_tesnost());
		modelAndView.addObject("m12_cas", formular.getOdprasovanie().getM12_cas());
		modelAndView.addObject("m115_cas", formular.getOdprasovanie().getM115_cas());
		modelAndView.addObject("m12_podtlak", formular.getOdprasovanie().getM12_podtlak());
		modelAndView.addObject("m115_funkcnost_oklepavacieho_zariadenia", formular.getOdprasovanie().getM115_funkcnost_oklepavacieho_zariadenia());
		modelAndView.addObject("m12_datum_zmeny_hadic", formular.getOdprasovanie().getM12_datum_zmeny_hadic());
		modelAndView.addObject("m115_chod_snekoveho_dopravnika", formular.getOdprasovanie().getM115_chod_snekoveho_dopravnika());
		modelAndView.addObject("m12_funkcnost_tesnost", formular.getOdprasovanie().getM12_funkcnost_tesnost());
		modelAndView.addObject("m115_funkcnost_celistvost", formular.getOdprasovanie().getM115_funkcnost_celistvost());
		modelAndView.addObject("herdingCas", formular.getOdprasovanie().getHerdingCas());
		modelAndView.addObject("herdingCistiaceImpulzy", formular.getOdprasovanie().getHerdingCistiaceImpulzy());
		modelAndView.addObject("herdingChodVyprazdnovaciehoZariadenia", formular.getOdprasovanie().getHerdingChodVyprazdnovaciehoZariadenia());
		return modelAndView;
	}
}