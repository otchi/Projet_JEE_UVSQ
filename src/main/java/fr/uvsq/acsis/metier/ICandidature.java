package fr.uvsq.acsis.metier;

import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.entities.Curuculium;
import fr.uvsq.acsis.entities.Dossier;
import fr.uvsq.acsis.entities.ExperiencePro;
import fr.uvsq.acsis.entities.ExterneFormation;

public interface ICandidature {
	public void createDossier(Dossier dossier,Long idCandidat);
	public void createCuruculium(Curuculium curuculium,Long idDossier);
	public void addFormationToCV(ExterneFormation formation,Long idCuruculium);
	public void addExperienceProToCV(ExperiencePro experience,Long idCuruculium);
	public void candidateToFormation(Long idFormation,Long idCandidat);
	public Candidat getCandidature(Long idCandidature);
	
}
