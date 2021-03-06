package fr.uvsq.acsis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.uvsq.acsis.utils.EtatCandidature;
/**
 * 
 * @author amine
 *antité de candidat
 */
@SuppressWarnings("serial")
@Entity
@Table(name="candidat")
public class Candidat extends Utilisateur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCandidat;
	@OneToOne(mappedBy="candidat")
	private Dossier dossier;
	/**
	 * un candidat peut postuler a une seul formation
	 * une formation peut étre demandé par diffirent candidat
	 */
	@ManyToOne
	@JoinColumn(name="id_formation")
	private InstituteFormation formation;
	private EtatCandidature etat;
	
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Candidat(String nom, String prenom,String dateNaissance, 
			String mail) {
		super(nom, prenom, dateNaissance, mail);
		etat=EtatCandidature.NON_VALIDE;
		// TODO Auto-generated constructor stub
	}


	public Long getIdCandidat() {
		return idCandidat;
	}

	public void setIdCandidat(Long idCandidat) {
		this.idCandidat = idCandidat;
	}

	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	public InstituteFormation getFormation() {
		return formation;
	}
	public void setFormation(InstituteFormation formation) {
		this.formation = formation;
	}
	public EtatCandidature getEtat() {
		return etat;
	}
	public void setEtat(EtatCandidature etat) {
		this.etat = etat;
	}
	
}
