package fr.uvsq.acsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.metier.ICandidature;
import fr.uvsq.acsis.utils.Autentification;
@Controller
@RequestMapping(value="/candidature")
public class CandidatureController {
	@Autowired
	private ICandidature candidature;
	private Candidat candidat;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("SpringWeb")Autentification aut,ModelMap model){
		Long id=candidature.autentification(aut.getEmail(), aut.getPassword());
		candidat=candidature.getCandidature(id);
		model.addAttribute("formarion", candidature.allFormations());
		return new ModelAndView("informationPerso","command",candidat);
	}
}
