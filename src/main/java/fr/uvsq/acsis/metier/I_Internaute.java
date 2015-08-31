package fr.uvsq.acsis.metier;

import fr.uvsq.acsis.entities.Candidat;
/**
 * 
 * @author amine
 * interface metier des operation d'un visiteur anonyme
 */
public interface I_Internaute {
	public void createCandidature(Candidat candidat);
	public void updateCandidature(Candidat candidat);
	public Long autentification(String mail,String password);
	public Boolean changePassword(String mail);
	public Candidat getCandidatByMail(String mail);
}
