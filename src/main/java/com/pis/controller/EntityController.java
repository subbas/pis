package com.pis.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.pis.service.RolaService;

@Controller
@RequestMapping(value = "/")
public class EntityController {

	@Autowired
	private EntityService<Rola> rolaService;
	@Autowired
	private EntityService<Maerz> maerzService;
	/*@Autowired
	private EntityService<PracovnaSnimka> pracSnimkaService;*/
	@Autowired
	private EntityService<ZamMaerz> zamMaerzService;
	@Autowired
	private EntityService<Zamestnanec> zamestnanecService;
	
	private List<Integer> zmenaList;
	
	@RequestMapping(value = "/get")
	public ModelAndView zobraz() {
		ModelAndView modelAndView = new ModelAndView("zobraz");
		List<Rola> role = rolaService.getEntities();
		modelAndView.addObject("role", role);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addMaerzPage() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form");
		modelAndView.addObject("formular", new Formular());
		zmenaList = new ArrayList();
		zmenaList.add(1);
		zmenaList.add(2);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingMaerz(@ModelAttribute Formular formular) {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form");
		
		maerzService.add(formular.getMaerz());
		
		ZamMaerz zamMaerz = new ZamMaerz();
		zamMaerz.setMaerz(formular.getMaerz());
		zamMaerz.setZamestnanec(zamestnanecService.getEntity(1));
		zamMaerz.setDatum(new Date());
		zamMaerz.setZmena(formular.getZamMaerz().getZmena());
		zamMaerzService.add(zamMaerz);
		
		//zamMaerzService.delete(zamMaerz.getId());
		//maerzService.delete(formular.getMaerz().getId());
		String message = "Maerz bol úspešne pridaný.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

}
