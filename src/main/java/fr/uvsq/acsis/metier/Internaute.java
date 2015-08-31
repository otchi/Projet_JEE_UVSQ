package fr.uvsq.acsis.metier;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import fr.uvsq.acsis.dao.InstitueDAO;
import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.utils.PasswordGenarateur;
/**
 * 
 * @author amine
 * implementation de l'interface metier d'un utilisateur non autentifier
 */
@Transactional
public class Internaute implements I_Internaute {
	InstitueDAO dao;

	@Override
	public void createCandidature(Candidat candidat) {
		// TODO Auto-generated method stub
		dao.addCandidat(candidat);

	}

	@Override
	public Boolean changePassword(String mail) {
		try{
			Candidat candidat = dao.getCandidatByMail(mail);
			candidat.setPassword(PasswordGenarateur.generate());
			// send with mail
			dao.updateCandidat(candidat);
		
		} catch (NoResultException e) {
			return false;
		}
		return true;
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

	public void setDao(InstitueDAO dao) {
		this.dao = dao;
	}

	@Override
	public Candidat getCandidatByMail(String mail) {
		// TODO Auto-generated method stub
		return dao.getCandidatByMail(mail);
	}

	@Override
	public void updateCandidature(Candidat candidat) {
		dao.updateCandidat(candidat);
		
	}
}
