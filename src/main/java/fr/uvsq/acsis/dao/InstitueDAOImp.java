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

public class InstitueDAOImp implements InstitueDAO{
	
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
		em.remove(getAdmin(idAdmin));
		
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
		em.remove(
				em.find(Candidat.class, idCandidat));
		
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
		em.remove(getCuruculium(idCuruculium));
		
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
		em.remove(getDossier(idDossier));
		
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
		em.remove(getExtFormation(idExtFormation));
		
	}
	
	@Override
	public ExterneFormation getExtFormation(Long idExtFormation) {
		return em.find(ExterneFormation.class, idExtFormation);
		
	}

	/**********************************************************/
	@Override
	public void setIFormation(InstituteFormation iFormation) {
		em.persist(iFormation);
		
	}

	@Override
	public void updateIFormation(InstituteFormation iFormation) {
		em.persist(iFormation);
		
	}

	@Override
	public void removeIFormation(Long idIFormation) {
		em.remove(getInstituteFormation(idIFormation));
		
	}

	@Override
	public InstituteFormation getInstituteFormation(Long idIFormation) {
		return em.find(InstituteFormation.class, idIFormation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InstituteFormation> allFormation() {
		return em.createQuery("select f from Role InstituteFormation f")
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
		em.remove(getRole(idRole));
		
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
		em.remove(getStagiaire(idstagiaire));
		
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
		getDossier(idDossier).setCv(curuculium);
		em.persist(curuculium);
		
	}

	@Override
	public void setDossier(Dossier dossier, Long idCandidat) {
		getCandidat(idCandidat).setDossier(dossier);
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

	@Override
	public void purgeDataBase() {
		em.createQuery("delete from  Curuculium").executeUpdate();
		
	}
	
	
	/***************************************************************/


}