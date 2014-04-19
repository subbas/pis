package com.pis.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/tlac", method = RequestMethod.GET)
	public ModelAndView tlacPage() {
		ModelAndView modelAndView = new ModelAndView("tlac");
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\pomoc\\hello.pdf"));
			document.open();
			Paragraph p = new Paragraph(Integer.toString(formular.getMaerz()
					.getId()));
			document.add(p);
			document.close();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/neodstranenePoruchy", method = RequestMethod.GET)
	public ModelAndView neodstranenePoruchyPage() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-majster", method = RequestMethod.GET)
	public ModelAndView addMaerzPageMajster() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-majster");
		formular = new Formular();
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("zmenaList", zmenaList);
		return modelAndView;
	}

	@RequestMapping(value = "/add-maerz-form-strojnik", method = RequestMethod.GET)
	public ModelAndView addMaerzPageStrojnik() {
		ModelAndView modelAndView = new ModelAndView("add-maerz-form-strojnik");
		if (formular == null) {
			formular = new Formular();
		}
		if (zmenaList == null) {
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
		/*ZamMaerz zamMaerz = new ZamMaerz();
		zamMaerz.setMaerz(form.getMaerz());
		zamMaerz.setZamestnanec(zamestnanecService.getEntity(1));
		zamMaerz.setDatum(new Date());
		zamMaerz.setZmena(form.getZamMaerz().getZmena());
		zamMaerzService.add(zamMaerz);*/
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
