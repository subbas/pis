package com.pis.controller;

import java.beans.PropertyEditorSupport;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pis.formular.Formular;
import com.pis.model.Maerz;
import com.pis.model.Odprasovanie;
import com.pis.model.Rola;
import com.pis.model.ZamMaerz;
import com.pis.model.Zamestnanec;
import com.pis.service.EntityService;
import com.pis.service.MaerzService;

@Controller
public class AdminController {

	@Autowired
	private EntityService<Zamestnanec> zamestnanecService;
	@Autowired
	private EntityService<Rola> rolaService;
	@Autowired
	private EntityService<ZamMaerz> zamMaerzService;
	@Autowired
	private MaerzService maerzServiceImpl;
	@Autowired
	private EntityService<Odprasovanie> odprasovanieService;

	private List<Zamestnanec> zamList;
	private List<Zamestnanec> aktList;
	private List<ZamMaerz> zamMaerzList;
	private List<Zamestnanec> majsterList;
	private List<Zamestnanec> velinarList;
	private List<Zamestnanec> strojnikList;
	private Formular formular;

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
		webDataBinder.registerCustomEditor(Zamestnanec.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String text) {
				Zamestnanec zam = zamestnanecService.getEntity(Integer.parseInt(text));
				setValue(zam);
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
		for (Zamestnanec z : zamList) {
			// z.setAktivny(1);
			// zamestnanecService.update(z);
			if (z.getAktivny() == 1) {
				aktList.add(z);
			}
		}
		modelAndView.addObject("zamList", aktList);
		return modelAndView;
	}

	@RequestMapping(value = "/list-of-maerz", method = RequestMethod.GET)
	public ModelAndView gotoMaerzPage() {
		ModelAndView modelAndView = new ModelAndView("admin/list-of-maerz");
		zamMaerzList = zamMaerzService.getEntities();
		modelAndView.addObject("zamMaerzList", zamMaerzList);
		return modelAndView;
	}

	@RequestMapping(value = "/maerz/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editMaerzPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("admin/edit-maerz-page");
		Maerz maerz = maerzServiceImpl.getEntity(id);
		List<Odprasovanie> odprasovanieList = odprasovanieService.getEntities();
		Odprasovanie odprasovanie = new Odprasovanie();
		for (Odprasovanie o : odprasovanieList) {
			if (o.getMaerz().getId() == id) {
				odprasovanie = o;
				break;
			}
		}
		ZamMaerz zamMaerz = new ZamMaerz();
		for (ZamMaerz z : zamMaerzList) {
			if (z.getMaerz().getId() == id) {
				zamMaerz = z;
				break;
			}
		}
		formular = new Formular();
		formular.setMaerz(maerz);
		formular.setOdprasovanie(odprasovanie);
		formular.setZamMaerz(zamMaerz);
		majsterList = new ArrayList<Zamestnanec>();
		majsterList = zamestnanecService.getAllMajster();
		majsterList.add(zamestnanecService.getEntity(11));
		velinarList = new ArrayList<Zamestnanec>();
		velinarList = zamestnanecService.getAllVelinar();
		velinarList.add(zamestnanecService.getEntity(11));
		strojnikList = new ArrayList<Zamestnanec>();
		strojnikList = zamestnanecService.getAllStrojnik();
		strojnikList.add(zamestnanecService.getEntity(11));
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
		modelAndView = vzorce(modelAndView);
		modelAndView.addObject("formular", formular);
		modelAndView.addObject("majsterList", majsterList);
		modelAndView.addObject("velinarList", velinarList);
		modelAndView.addObject("strojnikList", strojnikList);

		return modelAndView;
	}

	@RequestMapping(value = "/maerz/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editingMaerz(@ModelAttribute @Valid Formular form, @PathVariable Integer id, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("redirect:/maerz/edit/{" + id + "}");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/list-of-maerz");
		
		System.out.println(id);
		form.getMaerz().setId(id);
		form.getZamMaerz().setId(formular.getZamMaerz().getId());
		form.getZamMaerz().setDatum(formular.getZamMaerz().getDatum());
		form.getZamMaerz().setZmena(formular.getZamMaerz().getZmena());
		form.getZamMaerz().setZamestnanec1(formular.getZamMaerz().getZamestnanec1());
		form.getZamMaerz().setZamestnanec2(formular.getZamMaerz().getZamestnanec2());
		form.getZamMaerz().setZamestnanec3(formular.getZamMaerz().getZamestnanec3());
		form.getZamMaerz().setMaerz(form.getMaerz());
		form.getOdprasovanie().setId(formular.getOdprasovanie().getId());
		form.getOdprasovanie().setMaerz(form.getMaerz());
		
		maerzServiceImpl.update(form.getMaerz());
		zamMaerzService.update(form.getZamMaerz());
		odprasovanieService.update(form.getOdprasovanie());
		return modelAndView;
	}

	@RequestMapping(value = "/zam/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editZamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("admin/edit-zam-page");
		Zamestnanec zam = zamestnanecService.getEntity(id);
		List<Rola> rolaList = rolaService.getEntities();
		modelAndView.addObject("rolaList", rolaList);
		modelAndView.addObject("zam", zam);
		return modelAndView;
	}

	@RequestMapping(value = "/zam/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editingZam(@ModelAttribute @Valid Zamestnanec zam, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/list-of-zam");
		zam.setAktivny(1);
		zam.setHeslo(zamestnanecService.getEntity(id).getHeslo());
		zamestnanecService.update(zam);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addZamPage() {
		ModelAndView modelAndView = new ModelAndView("admin/add-zam-page");
		List<Rola> rolaList = rolaService.getEntities();
		modelAndView.addObject("rolaList", rolaList);
		modelAndView.addObject("zam", new Zamestnanec());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingZam(@ModelAttribute @Valid Zamestnanec zam) {
		ModelAndView modelAndView = new ModelAndView("redirect:/list-of-zam");

		String heslo = "heslo";
		MessageDigest md;
		StringBuffer sb;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(heslo.getBytes());
			byte byteData[] = md.digest();
			sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			System.out.println(sb.toString());
			zam.setHeslo(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		int id = zamestnanecService.getLastId() + 1;
		zam.setId(id);
		zam.setAktivny(1);
		zam.setOsobneCislo(id);
		zamestnanecService.add(zam);
		return modelAndView;
	}

	@RequestMapping(value = "/zam/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteZam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/list-of-zam");
		Zamestnanec zamToUpdate = zamestnanecService.getEntity(id);
		zamToUpdate.setAktivny(0);
		zamestnanecService.update(zamToUpdate);
		aktList.remove(id);
		modelAndView.addObject("zamList", aktList);
		return modelAndView;
	}

	public ModelAndView vzorce(ModelAndView model) {
		DecimalFormat d = new DecimalFormat("#.##");
		int mesiac = Calendar.getInstance().get(Calendar.MONTH) + 1;
		model.addObject("D16", Integer.toString(formular.getMaerz().getZasobnik1Plnenie() * 2));
		model.addObject("D17", Integer.toString(formular.getMaerz().getZasobnik2Plnenie() * 2));
		model.addObject("D18", Integer.toString(formular.getMaerz().getZasobnik5Plnenie() * 35 / 100));
		model.addObject("E23", d.format(formular.getMaerz().getVyrobaVapno6Skut() * 0.4));
		model.addObject("F23", d.format(formular.getMaerz().getVyrobaVapno6Skut() * 0.6));
		double G23 = maerzServiceImpl.getG23(mesiac);
		model.addObject("G23", d.format(G23));
		model.addObject("E24", d.format(formular.getMaerz().getVyrobaVapno17Skut() * 0.4));
		model.addObject("F24", d.format(formular.getMaerz().getVyrobaVapno17Skut() * 0.6));
		double G24 = maerzServiceImpl.getG24(mesiac);
		model.addObject("G24", d.format(G24));
		model.addObject("E25", d.format(formular.getMaerz().getVyrobaVapno35Skut() * 0.4));
		model.addObject("F25", d.format(formular.getMaerz().getVyrobaVapno35Skut() * 0.6));
		double G25 = maerzServiceImpl.getG25(mesiac);
		model.addObject("G25", d.format(G25));
		Float B26 = formular.getMaerz().getVyrobaVapno6Plan() + formular.getMaerz().getVyrobaVapno17Plan() + formular.getMaerz().getVyrobaVapno35Plan();
		model.addObject("B26", d.format(B26));
		Float C26 = formular.getMaerz().getVyrobaVapno6Skut() + formular.getMaerz().getVyrobaVapno17Skut() + formular.getMaerz().getVyrobaVapno35Skut();
		model.addObject("C26", d.format(C26));
		model.addObject("D26", d.format(C26 / B26 * 100));
		model.addObject("G26", d.format(G23 + G24 + G25));
		model.addObject("B29", d.format(formular.getMaerz().getVyrobaVapno6Plan() / 0.552));
		model.addObject("B30", d.format(formular.getMaerz().getVyrobaVapno17Plan() / 0.552));
		model.addObject("B31", d.format(formular.getMaerz().getVyrobaVapno35Plan() / 0.552));
		model.addObject("C32", d.format(formular.getMaerz().getVyrobaVapenecVsadzka6Skut() + formular.getMaerz().getVyrobaVapenecVsadzka17Skut() + formular.getMaerz().getVyrobaVapenecVsadzka35Skut()));
		model.addObject("F35", d.format(formular.getMaerz().getBriketizackaKonStav() - formular.getMaerz().getBriketizackaPocStav()));
		model.addObject("G35", d.format(formular.getMaerz().getFilter_M20_kon_stav() - formular.getMaerz().getFilter_M20_poc_stav()));
		model.addObject("B36", d.format(12 - formular.getMaerz().getChodPece()));
		model.addObject("F36", d.format(maerzServiceImpl.getF36(mesiac)));
		model.addObject("G36", d.format(maerzServiceImpl.getG36(mesiac)));
		return model;
	}

}
