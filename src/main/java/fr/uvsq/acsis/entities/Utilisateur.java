package fr.uvsq.acsis.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import fr.uvsq.acsis.metier.PasswordGenarator;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Utilisateur implements Serializable {
	@NotEmpty
	@Size(min=2,max=40)
	private String nom;
	@NotEmpty
	@Size(min=2,max=40)
	private String prenom;
	private Date dateNaissance;
	@Column	(unique=true)
	private String mail;
	@NotEmpty
	@Size(min=6)
	private String password;
	private Date dateInscription;
	
	
	public Utilisateur() {
		super();
	
	}
	
	public Utilisateur(String nom, String prenom, Date dateNaissance, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.password = PasswordGenarator.generate();
		this.dateInscription = new Date();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
}
