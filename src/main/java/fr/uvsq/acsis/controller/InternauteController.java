package fr.uvsq.acsis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.metier.I_Internaute;
import fr.uvsq.acsis.utils.Autentification;
import fr.uvsq.acsis.utils.EnvoiEmail;
import fr.uvsq.acsis.utils.PasswordGenarateur;

/**
 * 
 * @author amine
 *cantrolleur d'un visiteur anonyme
 */
@Controller
@RequestMapping(value="/authentification")
public class InternauteController {
	/**
	 * canstante des message afficher
	 */
	private static final String MSG_MOT_DE_PASS_INCORRECT=""
			+ "le mot de passe que vous avez saisie est incorect,"
			+ " si vous avez perdue  votre mot de pass veuillez cliquez sur le lien mot de pass perdu";
	private static final String MSG_ADRESS_MAIL_INCORRECT="le dossier que vous demandez n'existe pas "
			+ "veuillez cliqué qur le lien nouveau dossier si vous n'éte pas inscrit";
	
	
	private static final String NOM_CHAMP_AFFICHAGE="errorAutentification";
	private static final String AUTENTIFICATION_VIEW="authentification";
	
	/**
	 * interface metier d'un visiteur anonyme
	 */
	@Autowired
	private I_Internaute internaute;
	
	
	/**
	 * premier fenetre d'autetification (redirection depuis la jsp d'acceuil)
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView welcome(){
		 return new ModelAndView(AUTENTIFICATION_VIEW, "command", new Autentification());
	}
	
	/**
	 * 
	 * @param aut
	 * @param model
	 * @param httpSession
	 * 
	 * @return
	 * verification de l'autentification 
	 * et redirection vers le controlleur de candidature en cas de succée
	 */
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView autentification(@ModelAttribute("SpringWeb")Autentification aut, 
	   ModelMap model,HttpSession httpSession){
			
			Long response=internaute.autentification(aut.getEmail(), aut.getPassword());
			switch (response.intValue()) {
			case -1:
				model.addAttribute(NOM_CHAMP_AFFICHAGE, MSG_MOT_DE_PASS_INCORRECT);
				return new ModelAndView(AUTENTIFICATION_VIEW, "command", aut);
			
			case -2:
				model.addAttribute(NOM_CHAMP_AFFICHAGE, MSG_ADRESS_MAIL_INCORRECT);
				return new ModelAndView(AUTENTIFICATION_VIEW, "command", aut);
			default:
				httpSession.setAttribute("user", aut.getEmail());
				httpSession.setAttribute("pass", aut.getPassword());
				return new ModelAndView("redirect:candidature");
			}
	}
	@RequestMapping(value="/newPass",method=RequestMethod.GET)
	public String modifiePass(){
		return "newPass";
	}
	/**
	 * envoi de nouveau mot de pass aleatoire par mail
	 * @param request
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/newPass",method=RequestMethod.POST)
	public ModelAndView modifiePasswort(HttpServletRequest request,ModelMap model){
		Candidat candidat=internaute.getCandidatByMail(request.getParameter("mail"));
		if(candidat==null){
			model.addAttribute("errorMessage", "dossier inexistant");
			return new ModelAndView("newPass");
		}
		
		String newPass=PasswordGenarateur.generate();
		candidat.setPassword(newPass);
		internaute.updateCandidature(candidat);
		EnvoiEmail.envoiEmail(candidat.getMail(), newPass, candidat.getPrenom());
		model.addAttribute("message", "mot de pass envoyé a votre adress mail");
		return new ModelAndView("redirect:/authentification","command",new Autentification());
		
	}
	/**
	 * inscription d'un candidat 
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/inscription",method=RequestMethod.GET)
	public ModelAndView inscrition(ModelMap model){
		return new ModelAndView("inscription","command",new Candidat());
	}
	/**
	 * inscription puis redirection vers autentification
	 * @param candidat
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/inscription",method=RequestMethod.POST)
	public ModelAndView post_inscrition(@ModelAttribute("SpringWeb")Candidat candidat,
			ModelMap model){
			internaute.createCandidature(candidat);
		return new ModelAndView("redirect:/authentification","command",new Autentification());
	}
	
}
