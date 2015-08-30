package fr.uvsq.acsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.uvsq.acsis.metier.I_Internaute;
import fr.uvsq.acsis.utils.Autentification;

@Controller
@RequestMapping(value="/autentification")
public class InternauteController {
	private static final String MSG_MOT_DE_PASS_INCORRECT=""
			+ "le mot de passe que vous avez saisie est incorect,"
			+ " si vous avez perdue  votre mot de pass veuillez cliquez sur le lien mot de pass perdu";
	private static final String MSG_ADRESS_MAIL_INCORRECT="le dossier que vous demandez n'existe pas "
			+ "veuillez cliqué qur le lien nouveau dossier si vous n'éte pas inscrit";
	
	private static final String NOM_CHAMP_AFFICHAGE="errorAutentification";
	private static final String AUTENTIFICATION_VIEW="autentification";
	@Autowired
	private I_Internaute internaute;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView welcome(){
		 return new ModelAndView(AUTENTIFICATION_VIEW, "command", new Autentification());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView autentification(@ModelAttribute("SpringWeb")Autentification aut, 
	   ModelMap model){
			Long response=internaute.autentification(aut.getEmail(), aut.getPassword());
			switch (response.intValue()) {
			case -1:
				model.addAttribute(NOM_CHAMP_AFFICHAGE, MSG_MOT_DE_PASS_INCORRECT);
				return new ModelAndView(AUTENTIFICATION_VIEW, "command", aut);
			
			case -2:
				model.addAttribute(NOM_CHAMP_AFFICHAGE, MSG_ADRESS_MAIL_INCORRECT);
				return new ModelAndView(AUTENTIFICATION_VIEW, "command", aut);
			default:
				return new ModelAndView("redirect:candidature","command",aut);
			}
	}
}
