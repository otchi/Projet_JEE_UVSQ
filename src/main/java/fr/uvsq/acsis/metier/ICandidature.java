package fr.uvsq.acsis.metier;


import java.util.List;

import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.entities.Curuculium;
import fr.uvsq.acsis.entities.Dossier;
import fr.uvsq.acsis.entities.ExperiencePro;
import fr.uvsq.acsis.entities.ExterneFormation;
import fr.uvsq.acsis.entities.InstituteFormation;

public interface ICandidature {
	public Long autentification(String mail,String password);
	public void createDossier(Dossier dossier,Long idCandidat);
	public void createCuruculium(Curuculium curuculium,Long idDossier);
	public void addFormationToCV(ExterneFormation formation,Long idCuruculium);
	public void addExperienceProToCV(ExperiencePro experience,Long idCuruculium);
	public void candidateToFormation(Long idFormation,Long idCandidat);
	public Candidat getCandidature(Long idCandidature);
	public void removeCuruculium(Long idCuruculium);
	public void removeExperiencePro(Long idExperience);
	public void removeExtFormation(Long idExtFormation);
	public void updateDossier(Dossier dossier);
	public List<InstituteFormation> allFormations();
	
}
