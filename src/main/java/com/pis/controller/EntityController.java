package com.pis.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.pis.formular.Formular;
import com.pis.model.Maerz;
import com.pis.model.PracovnaSnimka;
import com.pis.model.Rola;
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
	@Autowired
	private EntityService<PracovnaSnimka> pracovnaSnimkaService;

	// formular
	private Formular formular;
	private List<Integer> zmenaList;
	private Boolean majsterForm = false;

	// pomocne
	private Boolean prvaZmena = false;
	private Boolean druhaZmena = false;
	private Boolean vytvor = false;
	private int maerzLastId = 1;
	private int pracovnaSnimkaLastId = 1;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "/neodstranenePoruchy", method = RequestMethod.GET)
	public ModelAndView neodstranenePoruchyPage() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		return modelAndView;
	}

	@RequestMapping(value = "/synch", method = RequestMethod.GET)
	public ModelAndView synch() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		formular = Formular.getInstance();
		formular.setMaerz(maerzService.getEntity(maerzLastId));
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	@RequestMapping(value = "/synchVelinar", method = RequestMethod.GET)
	public ModelAndView synchVelinar() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		formular = Formular.getInstance();
		formular.setMaerz(maerzService.getEntity(maerzLastId));
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	public void nastavZmenu() {
		Calendar calendar = Calendar.getInstance();
		Calendar zacZmeny = Calendar.getInstance();
		Calendar konZmeny = Calendar.getInstance();
		zacZmeny.set(Calendar.HOUR_OF_DAY, 6);
		zacZmeny.set(Calendar.MINUTE, 0);
		zacZmeny.set(Calendar.SECOND, 0);
		konZmeny.set(Calendar.HOUR_OF_DAY, 22);
		konZmeny.set(Calendar.MINUTE, 10);
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
		konZmeny.set(Calendar.HOUR_OF_DAY, 22);
		konZmeny.set(Calendar.MINUTE, 10);
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

	@RequestMapping(value = "/add-maerz-form-strojnik", method = RequestMethod.GET)
	public ModelAndView addMaerzPageStrojnik() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		nastavZmenu();
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			System.out.println("je nova zmena");
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId() + 1;
			modelAndView.addObject("formular", formular);
			return modelAndView;

		} else {
			System.out.println("nieje nova zmena");
			formular = Formular.getInstance();
			System.out.println(maerzService.getLastId());
			maerzLastId = maerzService.getLastId();
			formular.setMaerz(maerzService.getEntity(maerzLastId));
			pracovnaSnimkaLastId = pracovnaSnimkaService.getLastId();
			// formular.setPracSnimka(pracovnaSnimkaService.getEntities());
			modelAndView.addObject("formular", formular);
			return modelAndView;
		}
	}

	@RequestMapping(value = "/add-maerz-form-strojnik", method = RequestMethod.POST)
	public ModelAndView addingMaerzStrojnik(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		if (vytvor == true) {
			Formular.setInstance(form);
			maerzService.add(form.getMaerz());
			vytvor = false;
		} else {
			Formular.setInstance(form);
			form.getMaerz().setId(maerzLastId);
			maerzService.update(formular.getMaerz());
		}
		String message = "Maerz bol úspešne pridaný.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-velinar", method = RequestMethod.GET)
	public ModelAndView addMaerzPageVelinar(@ModelAttribute Formular formular) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		nastavZmenu();
		if (jeNovaZmena()) {
			Formular.setInstance(null);
			vytvor = true;
			System.out.println("je nova zmena");
			formular = Formular.getInstance();
			maerzLastId = maerzService.getLastId() + 1;
			modelAndView.addObject("formular", formular);
			return modelAndView;

		} else {
			System.out.println("nieje nova zmena");
			formular = Formular.getInstance();
			System.out.println(maerzService.getLastId());
			maerzLastId = maerzService.getLastId();
			formular.setMaerz(maerzService.getEntity(maerzLastId));
			pracovnaSnimkaLastId = pracovnaSnimkaService.getLastId();
			// formular.setPracSnimka(pracovnaSnimkaService.getEntities());
			modelAndView.addObject("formular", formular);
			return modelAndView;
		}

	}

	@RequestMapping(value = "/add-maerz-form-velinar", method = RequestMethod.POST)
	public ModelAndView addingMaerzVelinar(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		if (vytvor == true) {
			Formular.setInstance(form);
			maerzService.add(form.getMaerz());
			vytvor = false;
		} else {
			Formular.setInstance(form);
			form.getMaerz().setId(maerzLastId);
			maerzService.update(formular.getMaerz());
		}
		String message = "Maerz bol úspešne pridaný.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-veduci", method = RequestMethod.GET)
	public ModelAndView addingMaerzVeduci(@ModelAttribute Formular formular) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-veduci");
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-majster", method = RequestMethod.GET)
	public ModelAndView addMaerzPageMajster() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		formular = Formular.getInstance();
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-majster", method = RequestMethod.POST)
	public ModelAndView addingMaerzMajster(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		maerzService.add(form.getMaerz());
		/*
		 * ZamMaerz zamMaerz = new ZamMaerz();
		 * zamMaerz.setMaerz(form.getMaerz());
		 * zamMaerz.setZamestnanec(zamestnanecService.getEntity(1));
		 * zamMaerz.setDatum(new Date());
		 * zamMaerz.setZmena(form.getZamMaerz().getZmena());
		 * zamMaerzService.add(zamMaerz);
		 */
		String message = "Maerz bol úspešne pridaný.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("zmenaList", zmenaList);
		Formular.setInstance(form);
		return modelAndView;
	}
	/*
	 * @RequestMapping(value = "/tlac", method = RequestMethod.GET) public
	 * ModelAndView tlacPage() { ModelAndView modelAndView = new
	 * ModelAndView("tlac"); try { Document document = new Document();
	 * PdfWriter.getInstance(document, new FileOutputStream(
	 * "C:\\pomoc\\hello.pdf")); document.open(); Paragraph p = new
	 * Paragraph(Integer.toString(formular.getMaerz() .getId()));
	 * document.add(p); document.close(); } catch (Exception e2) {
	 * System.out.println(e2.getMessage()); } return modelAndView; }
	 */

}
