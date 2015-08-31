package fr.uvsq.acsis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.uvsq.acsis.entities.Admin;
import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.entities.Curuculium;
import fr.uvsq.acsis.entities.Dossier;
import fr.uvsq.acsis.entities.ExperiencePro;
import fr.uvsq.acsis.entities.ExterneFormation;
import fr.uvsq.acsis.entities.InstituteFormation;
import fr.uvsq.acsis.entities.Role;
import fr.uvsq.acsis.entities.Stagiaire;
/**
 * 
 * @author amine
 * implemention de la 
 *DAO
 */
public class InstitueDAOImp implements InstitueDAO{
	/**
	 * contexte de persistance charger depuis le context spring
	 */
	@PersistenceContext
	private EntityManager em;
	/**********************************************************/
	@Override
	public void addAdmin(Admin admin) {
		em.persist(admin);
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		em.merge(admin);
		
	}

	@Override
	public void removeAdmin(Long idAdmin) {
		Admin admin=getAdmin(idAdmin);
		em.refresh(admin);
		em.remove(admin);
		
	}

	@Override
	public Admin getAdmin(Long idAdmin) {
		return em.find(Admin.class, idAdmin);
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> allAdmin() {
		return em.createQuery("select c from Admin c")
							.getResultList();
	}
	/*************************************************************/
	@Override
	public void addCandidat(Candidat candidat) {
		em.persist(candidat);
		
	}

	@Override
	public void updateCandidat(Candidat candidat) {
		em.merge(candidat);
		
	}

	@Override
	public void removeCandidat(Long idCandidat) {
		Candidat candidat=getCandidat(idCandidat);
		em.refresh(candidat);
		em.remove(candidat);
		
	}

	@Override
	public Candidat getCandidat(Long idCandidat) {
		return em.find(Candidat.class, idCandidat);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidat> allCandidat() {
		return  em.createQuery("select c from Candidat c")
				.getResultList();
	}
	
	@Override
	public Candidat getCandidatByMail(String mail) {
	    TypedQuery<Candidat> query=em.createQuery("select c from Candidat c where c.mail=:mail",Candidat.class);
		return query.setParameter("mail", mail).getSingleResult();
	}
	/**********************************************************/


	@Override
	public void updateCuruculium(Curuculium curuculium) {
		em.merge(curuculium);
		
	}

	@Override
	public void removeCuruculium(Long idCuruculium) {
		Curuculium curuculium=getCuruculium(idCuruculium);
		em.refresh(curuculium);
		em.remove(curuculium);
		
	}

	@Override
	public Curuculium getCuruculium(Long idCuruculium) {
		return em.find(Curuculium.class, idCuruculium);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curuculium> allCuruculium() {
		return em.createQuery("select c from Curuculium c")
				.getResultList();
	}
	
	/**********************************************************/


	@Override
	public void updateDossier(Dossier dossier) {
		em.merge(dossier);
		
	}

	@Override
	public void removeDossier(Long idDossier) {
		Dossier dossier=getDossier(idDossier);
		em.refresh(dossier);
		em.remove(dossier);
		
	}

	@Override
	public Dossier getDossier(Long idDossier) {
		return em.find(Dossier.class, idDossier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dossier> allDossier() {
		return em.createQuery("select d from Dossier d")
				.getResultList();
	}



	@Override
	public void updateExperiencePro(ExperiencePro experiencePro) {
		em.merge(experiencePro);
		
	}
	

	@Override
	public void removeExperiencePro(Long idExperiencePro) {
		ExperiencePro experience=getExperiencePro(idExperiencePro);
		em.refresh(experience);
		em.remove(getExperiencePro(idExperiencePro));
		
	}
	
	@Override
	public ExperiencePro getExperiencePro(Long idExperiencePro) {
		return em.find(ExperiencePro.class, idExperiencePro);
		
	}
	
	/**********************************************************/


	@Override
	public void updateExtFormation(ExterneFormation extFormation) {
		em.merge(extFormation);
		
	}
	

	@Override
	public void removeExtFormation(Long idExtFormation) {
		ExterneFormation formation=getExtFormation(idExtFormation);
		em.refresh(formation);
		em.remove(formation);
		
	}
	
	@Override
	public ExterneFormation getExtFormation(Long idExtFormation) {
		return em.find(ExterneFormation.class, idExtFormation);
		
	}

	/**********************************************************/
	@Override
	public void addIFormation(InstituteFormation iFormation) {
		em.persist(iFormation);
		
	}

	@Override
	public void updateIFormation(InstituteFormation iFormation) {
		em.merge(iFormation);
		
	}

	@Override
	public void removeIFormation(Long idFormation) {
		InstituteFormation formation=getInstituteFormation(idFormation);
		em.refresh(formation);
		em.remove(formation);
		
	}

	@Override
	public InstituteFormation getInstituteFormation(Long idIFormation) {
		return em.find(InstituteFormation.class, idIFormation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InstituteFormation> allFormation() {
		return em.createQuery("select f from InstituteFormation f")
				.getResultList();
	}

	/**********************************************************/
	@Override
	public void addRole(Role role) {
		em.persist(role);
		
	}

	@Override
	public void updateRole(Role role) {
		em.merge(role);
		
	}

	@Override
	public void removeRole(Long idRole) {
		Role role=getRole(idRole);
		em.refresh(role);
		em.remove(role);
		
	}
	
	@Override
	public Role getRole(Long idRole) {
		return em.find(Role.class, idRole);
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> allRole() {
		return em.createQuery("select r from Role r")
				.getResultList();
	}
	
	/**********************************************************/
	@Override
	public void addStagiaire(Stagiaire stagiaire) {
		em.persist(stagiaire);
		
	}

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		em.merge(stagiaire);
		
	}

	@Override
	public void removeStagiaire(Long idstagiaire) {
		Stagiaire stagiaire=getStagiaire(idstagiaire);
		em.refresh(stagiaire);
		em.remove(stagiaire);
		
	}
	
	@Override
	public Stagiaire getStagiaire(Long idstagiaire) {
		return em.find(Stagiaire.class, idstagiaire);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stagiaire> allStagiaire() {
		return em.createQuery("select s from Stagiaire s")
				.getResultList();
	}

	@Override
	public void affectRole(Long idRole, Long idAdmin) {
		getAdmin(idAdmin).setRole(getRole(idRole));
		
	}

	@Override
	public void CandidateToFormation(Long idFormation, Long idCandidat) {
		getCandidat(idCandidat).setFormation(getInstituteFormation(idFormation));
		
	}

	@Override
	public void setCuruculium(Curuculium curuculium, Long idDossier) {
		Dossier dossier=getDossier(idDossier);
		curuculium.setDossier(dossier);
		dossier.setCv(curuculium);
		em.persist(curuculium);
		
	}

	@Override
	public void setDossier(Dossier dossier, Long idCandidat) {
		Candidat candidat=getCandidat(idCandidat);
		dossier.setCandidat(candidat);
		candidat.setDossier(dossier);
		em.persist(dossier);
		
	}

	@Override
	public void addExperiencePro(ExperiencePro experiencePro, Long idCuruculium) {
		getCuruculium(idCuruculium).addExperiencePro(experiencePro);
		em.persist(experiencePro);
		
	}

	@Override
	public void addExtFormation(ExterneFormation extFormation, Long idCuruculium) {
		getCuruculium(idCuruculium).addFormation(extFormation);
		em.persist(extFormation);
	}

	@Override
	public void affectFormation(Long idFormation, Long idStagiaire) {
		getStagiaire(idStagiaire).setFormation(getInstituteFormation(idFormation));
		
	}

	
	
	/***************************************************************/


}
