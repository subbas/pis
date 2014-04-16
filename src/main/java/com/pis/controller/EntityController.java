package com.pis.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	private EntityService<Rola> rolaService;
	@Autowired
	private EntityService<Maerz> maerzService;
	@Autowired
	private EntityService<ZamMaerz> zamMaerzService;
	@Autowired
	private EntityService<Zamestnanec> zamestnanecService;
	@Autowired
	private EntityService<PracovnaSnimka> pracovnaSnimkaService;

	//formular
	private Formular formular;
	private List<Integer> zmenaList;
	

	@RequestMapping(value = "/add-maerz-form-majster", method = RequestMethod.GET)
	public ModelAndView addMaerzPageMajster() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		if(formular == null) {
			formular = new Formular();
		}
		if(zmenaList == null) {
			zmenaList = new ArrayList<Integer>();
			zmenaList.add(1);
			zmenaList.add(2);
		}
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-maerz-form-strojnik", method = RequestMethod.GET)
	public ModelAndView addMaerzPageStrojnik() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		if(formular == null) {
			formular = new Formular();
		}
		if(zmenaList == null) {
			zmenaList = new ArrayList<Integer>();
			zmenaList.add(1);
			zmenaList.add(2);
		}
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-majster", method = RequestMethod.POST)
	public ModelAndView addingMaerzMajster(@ModelAttribute Formular form) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		maerzService.add(form.getMaerz());
		ZamMaerz zamMaerz = new ZamMaerz();
		zamMaerz.setMaerz(form.getMaerz());
		zamMaerz.setZamestnanec(zamestnanecService.getEntity(1));
		zamMaerz.setDatum(new Date());
		zamMaerz.setZmena(form.getZamMaerz().getZmena());
		zamMaerzService.add(zamMaerz);
		PracovnaSnimka pracSnimka = new PracovnaSnimka();
		pracSnimka.setMaerz(form.getMaerz());
		pracSnimka.setRola(rolaService.getEntity(4));	
		//Time dt = form.getPracSnimka().getOdkedy();
		
		pracSnimka.setOdkedy(form.getPracSnimka().getOdkedy());
		pracSnimka.setDokedy(form.getPracSnimka().getDokedy());
		pracSnimka.setPopis(form.getPracSnimka().getPopis());
		pracovnaSnimkaService.add(pracSnimka);		
		String message = "Maerz bol úspešne pridaný.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("zmenaList", zmenaList);
		formular = form;
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-veduci", method = RequestMethod.GET)
	public ModelAndView addingMaerzVeduci(@ModelAttribute Formular formular) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-veduci");
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-velinar", method = RequestMethod.GET)
	public ModelAndView addingMaerzVelinar(@ModelAttribute Formular formular) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-velinar");
		return modelAndView;
	}

}
