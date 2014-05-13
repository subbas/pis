package com.pis.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pis.model.Rola;
import com.pis.model.Zamestnanec;
import com.pis.service.EntityService;

@Controller
public class AdminController {
	
	@Autowired
	private EntityService<Zamestnanec> zamestnanecService;
	@Autowired
	private EntityService<Rola> rolaService;
	private List<Zamestnanec> zamList;
	private List<Zamestnanec> aktList;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		webDataBinder.registerCustomEditor(Rola.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String text) {
				Rola rola = rolaService.getEntity(Integer.parseInt(text));
				setValue(rola);
			}
		});
	}
	
	
	@RequestMapping(value = "/admin-page", method = RequestMethod.GET)
	public ModelAndView gotoAdminPage() {
		ModelAndView modelAndView = new ModelAndView("admin/admin-page");
		return modelAndView;
	}
	
	@RequestMapping(value = "/list-of-zam", method = RequestMethod.GET)
	public ModelAndView gotoZamestnanciPage() {
		ModelAndView modelAndView = new ModelAndView("admin/list-of-zam");
		zamList = zamestnanecService.getEntities();
		aktList = new ArrayList<Zamestnanec>();
		for (Zamestnanec z:zamList) {
			//z.setAktivny(1);
			//zamestnanecService.update(z);
			if(z.getAktivny() == 1) {
				aktList.add(z);
			}
		}
		modelAndView.addObject("zamList", aktList);
		return modelAndView;
	}
	
	@RequestMapping(value="/zam/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editZamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("admin/edit-zam-page");
		Zamestnanec zam = zamestnanecService.getEntity(id);
		List<Rola> rolaList = rolaService.getEntities();
		modelAndView.addObject("rolaList", rolaList);
		modelAndView.addObject("zam",zam);
		return modelAndView;
	}
	
	@RequestMapping(value="/zam/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editingZam(@ModelAttribute @Valid Zamestnanec zam, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/list-of-zam");
		zam.setAktivny(1);
		zam.setHeslo(zamestnanecService.getEntity(id).getHeslo());
		zamestnanecService.update(zam);
		return modelAndView;
	}
	
	@RequestMapping(value="/zam/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteZam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/list-of-zam");
		Zamestnanec zamToUpdate = zamestnanecService.getEntity(id);
		zamToUpdate.setAktivny(0);
		zamestnanecService.update(zamToUpdate);	
		aktList.remove(id);
		modelAndView.addObject("zamList", aktList);
		return modelAndView;
	}

	

}
