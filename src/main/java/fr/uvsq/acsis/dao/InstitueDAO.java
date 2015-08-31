package fr.uvsq.acsis.dao;

import java.util.List;

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
 * intéface DAO definie les opperation possible
 */
public interface InstitueDAO {
	/****************************************************/	
	public void addAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void removeAdmin(Long idAdmin);
	public Admin getAdmin(Long idAdmin);
	public List<Admin> allAdmin();
	public void affectRole(Long idRole,Long idAdmin);
	
	
	/****************************************************/		
	public void addCandidat(Candidat candidat);
	public void updateCandidat(Candidat candidat);
	public void removeCandidat(Long idCandidat);
	public Candidat getCandidat(Long idCandidat);
	public List<Candidat> allCandidat();
	public Candidat getCandidatByMail(String mail);
	public void CandidateToFormation(Long idFormation,Long idCandidat);
	/****************************************************/		
	public void setCuruculium(Curuculium curuculium,Long idDossier);
	public void updateCuruculium(Curuculium curuculium);
	public void removeCuruculium(Long idCuruculium);
	public Curuculium getCuruculium(Long idCuruculium );
	public List<Curuculium> allCuruculium();
	
	/****************************************************/	
	public void setDossier(Dossier dossier,Long idCandidat);
	public void updateDossier(Dossier dossier);
	public void removeDossier(Long idDossier);
	public Dossier getDossier(Long idDossier);
	public List<Dossier> allDossier();
	

	
	
	/****************************************************/	
	public void addExperiencePro(ExperiencePro experiencePro,Long idCuruculium);
	public void updateExperiencePro(ExperiencePro experiencePro);
	public void removeExperiencePro(Long idExperiencePro);
	public ExperiencePro getExperiencePro(Long idExperiencePro);
	
	
	/****************************************************/	
	public void addExtFormation(ExterneFormation extFormation,Long idCuruculium);
	public void updateExtFormation(ExterneFormation extFormation);
	public void removeExtFormation(Long idExtFormation);
	public ExterneFormation getExtFormation(Long idExtFormation);
	
	/****************************************************/	
	public void addIFormation(InstituteFormation iFormation);
	public void updateIFormation(InstituteFormation iFormation);
	public void removeIFormation(Long idIFormation);
	public InstituteFormation getInstituteFormation(Long idIFormation);
	public List<InstituteFormation> allFormation();
	
	
	
	/****************************************************/	
	public void addRole(Role role);
	public void updateRole(Role role);
	public void removeRole(Long idRole);
	public Role getRole(Long idRole);
	public  List<Role> allRole();


	/****************************************************/	
	public void addStagiaire(Stagiaire stagiaire);
	public void updateStagiaire(Stagiaire stagiaire);
	public void removeStagiaire(Long idstagiaire);
	public Stagiaire getStagiaire(Long idstagiaire);
	public List<Stagiaire> allStagiaire();
	public void affectFormation(Long idFormation,Long idStagiaire);
	
	
	
	/****************************************************/
	

}
