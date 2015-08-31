package fr.uvsq.acsis.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import fr.uvsq.acsis.utils.PasswordGenarateur;
/**
 * 
 * @author amine
 * super class des utilisateur inscrit ou candidat
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Utilisateur implements Serializable {

	@Size(min=2,max=40)
	private String nom;
	@Size(min=2,max=40)
	private String prenom;
	private String dateNaissance;
	@Column	(unique=true)
	private String mail;
	@Size(min=6)
	private String password;
	private Date dateInscription;
	
	
	public Utilisateur() {
		super();
		
	
	}
	
	public Utilisateur(String nom, String prenom, String dateNaissance, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.password = PasswordGenarateur.generate();
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
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) throws ParseException {
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
