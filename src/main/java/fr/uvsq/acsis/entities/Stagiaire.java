package fr.uvsq.acsis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author amine
 *entité des etudiant de l'intitue
 */
@SuppressWarnings("serial")
@Entity
@Table(name="stagiaire")
public class Stagiaire extends Utilisateur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStagiaire;
	private String certificatDeScolarite;
	@ManyToOne
	@JoinColumn(name="id_formation")
	private InstituteFormation formation;
	
	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stagiaire(String nom, String prenom, String dateNaissance, String mail) {
		super(nom, prenom, dateNaissance, mail);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Long getIdStagiaire() {
		return idStagiaire;
	}

	public void setIdStagiaire(Long idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	public InstituteFormation getFormation() {
		return formation;
	}
	public void setFormation(InstituteFormation formation) {
		this.formation = formation;
	}
	public String getCertificatDeScolarite() {
		return certificatDeScolarite;
	}
	public void setCertificatDeScolarite(String certificatDeScolarite) {
		this.certificatDeScolarite = certificatDeScolarite;
	}
}
