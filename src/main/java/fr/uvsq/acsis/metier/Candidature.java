package fr.uvsq.acsis.metier;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import fr.uvsq.acsis.dao.InstitueDAO;
import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.entities.Curuculium;
import fr.uvsq.acsis.entities.Dossier;
import fr.uvsq.acsis.entities.ExperiencePro;
import fr.uvsq.acsis.entities.ExterneFormation;
import fr.uvsq.acsis.entities.InstituteFormation;

@Transactional
public class Candidature implements ICandidature {
	InstitueDAO dao;

	@Override
	public void createDossier(Dossier dossier, Long idCandidat) {
		dao.setDossier(dossier, idCandidat);

	}

	@Override
	public void createCuruculium(Curuculium curuculium, Long idDossier) {
		dao.setCuruculium(curuculium, idDossier);

	}

	@Override
	public void addFormationToCV(ExterneFormation formation, Long idCuruculium) {
		dao.addExtFormation(formation, idCuruculium);

	}

	@Override
	public void addExperienceProToCV(ExperiencePro experience, Long idCuruculium) {
		dao.addExperiencePro(experience, idCuruculium);

	}

	@Override
	public void candidateToFormation(Long idFormation, Long idCandidat) {
		dao.CandidateToFormation(idFormation, idCandidat);

	}

	@Override
	public Candidat getCandidature(Long idCandidat) {
		return dao.getCandidat(idCandidat);
	}

	public void setDao(InstitueDAO dao) {
		this.dao = dao;
	}

	@Override
	public void removeCuruculium(Long idCuruculium) {
		dao.removeCuruculium(idCuruculium);

	}

	@Override
	public void removeExperiencePro(Long idExperience) {
		dao.removeExperiencePro(idExperience);

	}

	@Override
	public void removeExtFormation(Long idExtFormation) {
		dao.removeExtFormation(idExtFormation);

	}

	@Override
	public void updateDossier(Dossier dossier) {
		dao.updateDossier(dossier);

	}

	@Override
	public Long autentification(String mail, String password) {

		try {
			Candidat candidat = dao.getCandidatByMail(mail);
			if (candidat.getPassword().equals(password))
				return candidat.getIdCandidat();
		} catch (NoResultException e) {
			return (long) -2;
		}
		return (long) -1;
	}

	@Override
	public List<InstituteFormation> allFormations() {
		// TODO Auto-generated method stub
		return dao.allFormation();
	}

}
