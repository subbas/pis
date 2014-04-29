package com.pis.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pis.formular.Formular;
import com.pis.model.Maerz;
import com.pis.model.ZamMaerz;
import com.pis.model.Zamestnanec;
import com.pis.service.EntityService;

@Controller
@RequestMapping(value = "/")
public class EntityController {

	/*
	 * @Autowired private EntityService<Rola> rolaService;
	 */
	@Autowired
	private EntityService<Maerz> maerzService;
	@Autowired
	private EntityService<ZamMaerz> zamMaerzService;
	@Autowired
	private EntityService<Zamestnanec> zamestnanecService;

	// formular
	private Formular formular;
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

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
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
		return modelAndView;
	}

	@RequestMapping(value = "/synchVelinar", method = RequestMethod.GET)
	public ModelAndView synchVelinar() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		modelAndView.addObject("majsterList", majsterList);
		modelAndView.addObject("velinarList", velinarList);
		modelAndView.addObject("strojnikList", strojnikList);
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
			maerzLastId = maerzService.getLastId() + 1;
			formular.setMaerz(new Maerz());
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId();
			formular.setMaerz(maerzService.getEntity(maerzLastId));
		}
		nastavDatumAZmena();
		vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-strojnik", method = RequestMethod.POST)
	public ModelAndView addingMaerzStrojnik(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		form.getMaerz().setId(maerzLastId);
		//formular = Formular.getInstance();
		if (vytvor == true) {
			maerzService.add(form.getMaerz());
			vytvor = false;
		} else {
			maerzService.updateStrojnik(form.getMaerz());
		}
		formular.setMaerz(maerzService.getEntity(maerzLastId));
		// MODEL AND VIEW
		vzorce(modelAndView);
		modelAndView.addObject("message", message);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-velinar", method = RequestMethod.GET)
	public ModelAndView addMaerzPageVelinar(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		nastavZmenu();
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId() + 1;
			zamMaerzLastId = zamMaerzService.getLastId() + 1;
			formular.setMaerz(new Maerz());
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId();
			zamMaerzLastId = zamMaerzService.getLastId();
			formular.setMaerz(maerzService.getEntity(maerzLastId));
		}
		// NASTAVENIE PREMENNYCH FORMULARA
		nastavDatumAZmena();
		vzorce(modelAndView);
		majsterList = new ArrayList<Zamestnanec>();
		majsterList = zamestnanecService.getAllMajster();
		velinarList = new ArrayList<Zamestnanec>();
		velinarList = zamestnanecService.getAllVelinar();
		strojnikList = new ArrayList<Zamestnanec>();
		strojnikList = zamestnanecService.getAllStrojnik();
		// MODEL AND VIEW
		modelAndView.addObject("majsterList", majsterList);
		modelAndView.addObject("velinarList", velinarList);
		modelAndView.addObject("strojnikList", strojnikList);
		modelAndView.addObject("formular", formular);
		return modelAndView;

	}

	@RequestMapping(value = "/add-maerz-form-velinar", method = RequestMethod.POST)
	public ModelAndView addingMaerzVelinar(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		form.getMaerz().setId(maerzLastId);
		//formular = Formular.getInstance();
		if (vytvor == true) {
			// MAERZ
			maerzService.add(form.getMaerz());
			// ZAM_MAERZ
			/*
			 * ZamMaerz zamMaerz = new ZamMaerz();
			 * zamMaerz.setMaerz(form.getMaerz());
			 * zamMaerz.setZamestnanec(zamestnanecService.getEntity(1));
			 * zamMaerz.setDatum(new Date());
			 * zamMaerz.setZmena(form.getZamMaerz().getZmena());
			 * zamMaerzService.add(zamMaerz);
			 */
			vytvor = false;
		} else {
			// MAERZ
			maerzService.updateVelinar(form.getMaerz());
		}
		formular.setMaerz(maerzService.getEntity(maerzLastId));
		// MODEL AND VIEW
		modelAndView.addObject("message", message);
		modelAndView.addObject("majsterList", majsterList);
		modelAndView.addObject("velinarList", velinarList);
		modelAndView.addObject("strojnikList", strojnikList);
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-veduci", method = RequestMethod.GET)
	public ModelAndView addingMaerzVeduci(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-veduci");
		nastavZmenu();
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId() + 1;
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId();
			formular.setMaerz(maerzService.getEntity(maerzLastId));
		}
		modelAndView.addObject("formular", formular);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-majster", method = RequestMethod.GET)
	public ModelAndView addMaerzPageMajster() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		nastavZmenu();
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId() + 1;
		} else {
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId();
			formular.setMaerz(maerzService.getEntity(maerzLastId));
		}
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
		if (calendar.after(zacZmeny) && calendar.before(konZmeny)
				&& prvaZmena == true && druhaZmena == false) {
			return false;
		} else if (calendar.after(zacZmeny) && calendar.before(konZmeny)
				&& prvaZmena == true && druhaZmena == true) {
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
		DecimalFormat d= new DecimalFormat("#.##");
		model.addObject("D16",
				Integer.toString(formular.getMaerz().getZasobnik1Plnenie() * 2));
		model.addObject("D17",
				Integer.toString(formular.getMaerz().getZasobnik2Plnenie() * 2));
		model.addObject("D18", Integer.toString(formular.getMaerz()
				.getZasobnik5Plnenie() * 35 / 100));
		model.addObject("E23", d.format(formular.getMaerz().getVyrobaVapno6Skut()*0.4));
		model.addObject("F23", d.format(formular.getMaerz().getVyrobaVapno6Skut()*0.6));
		model.addObject("G23", "0");
		model.addObject("E24",d.format(formular.getMaerz().getVyrobaVapno17Skut()*0.4));
		model.addObject("F24", d.format(formular.getMaerz().getVyrobaVapno17Skut()*0.6));
		model.addObject("G24", "0");
		model.addObject("E25", d.format(formular.getMaerz().getVyrobaVapno35Skut()*0.4));
		model.addObject("F25", d.format(formular.getMaerz().getVyrobaVapno35Skut()*0.6));
		model.addObject("G25", "0");
		Float B26 = formular.getMaerz().getVyrobaVapno6Plan()+formular.getMaerz().getVyrobaVapno17Plan()+formular.getMaerz().getVyrobaVapno35Plan();
		model.addObject("B26", d.format(B26));
		Float C26 = formular.getMaerz().getVyrobaVapno6Skut()+formular.getMaerz().getVyrobaVapno17Skut()+formular.getMaerz().getVyrobaVapno35Skut();
		model.addObject("C26", d.format(C26));
		model.addObject("D26", d.format(C26/B26*100));
		model.addObject("G26",  "0");
		model.addObject("B29", d.format(formular.getMaerz().getVyrobaVapno6Plan()/0.552));
		model.addObject("B30", d.format(formular.getMaerz().getVyrobaVapno17Plan()/0.552));
		model.addObject("B31", d.format(formular.getMaerz().getVyrobaVapno35Plan()/0.552));
		model.addObject("C32", d.format(formular.getMaerz().getVyrobaVapenecVsadzka6Skut()+formular.getMaerz().getVyrobaVapenecVsadzka17Skut()+formular.getMaerz().getVyrobaVapenecVsadzka35Skut()));
		model.addObject("F35", d.format(formular.getMaerz().getBriketizackaKonStav()-formular.getMaerz().getBriketizackaPocStav()));
		model.addObject("G35", d.format(formular.getMaerz().getFilter_M20_kon_stav()-formular.getMaerz().getFilter_M20_poc_stav()));
		model.addObject("B36", d.format(12-formular.getMaerz().getChodPece()));
		model.addObject("F36", "0");
		model.addObject("G36", "0");
		return model;
	}
}
