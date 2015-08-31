package fr.uvsq.acsis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.metier.ICandidature;
/**
 * 
 * @author amine
 *controlleur de candidature 
 */

@Controller
@RequestMapping(value="/candidature")
public class CandidatureController {
	@Autowired
	private ICandidature candidature;
	private Candidat candidat;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(HttpSession Session,ModelMap model){
		candidat=candidature.getCandidature(
							candidature.autentification(Session.getAttribute("user").toString(),
														Session.getAttribute("pass").toString()));

		model.addAttribute("formarions", candidature.allFormations());
		return new ModelAndView("informationPerso","command",candidat);
	}
}
