package com.pis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

	@RequestMapping(value = "/")
	public ModelAndView mainPage() {
		return new ModelAndView("login");
	}
	
	/*@RequestMapping(value = "/**")
	public ModelAndView url() {
		return new ModelAndView("login");
	}*/
	
	/*@RequestMapping(value = "/*")
	public ModelAndView url1() {
		return new ModelAndView("login");
	}*/
	
	@RequestMapping(value = "/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/index")
	public ModelAndView indexPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model, HttpServletRequest request) {
        System.out.println(request.getServletPath());
 		model.addAttribute("message", "Zadali ste neplatné prihlasovacie údaje!");
		return "login";
 	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		model.addAttribute("message", "Boli ste úspešne odhlásený!");
 		return "login";
 	}
	
	@RequestMapping(value="/accessDenied", method = RequestMethod.GET)
	public String accessDenied(ModelMap model, HttpServletRequest request) {
		model.addAttribute("message", "Nemáte práva!");
 		return "login";
 	}

	
	/*
	 * @RequestMapping(value="/add-maerz-form", method = RequestMethod.GET)
	 * public ModelAndView printAddMaerzForm(ModelMap model) {
	 * 
	 * User user =
	 * (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal
	 * (); String name = user.getUsername();
	 * 
	 * model.addAttribute("username", name); model.addAttribute("message",
	 * "Spring Security login + database example"); return new
	 * ModelAndView("add-maerz-form");
	 * 
	 * }
	 */

}
