package fr.uvsq.acsis.metier;

import fr.uvsq.acsis.entities.Candidat;

public interface I_Internaute {
	public void createCandidature(Candidat candidat);
	public Long autentification(String mail,String password);
	public Boolean changePassword(String mail);
}
