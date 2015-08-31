package fr.uvsq.acsis.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author amine
 * super class des formation (les formation dans les cv ou
 * de l'institue)
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Formation implements Serializable{
	@NotEmpty
	@Size(min=4)
	private String nom;
	private String niveau;
	
	
	public Formation() {
		super();

		
	}

	public Formation(String nom, String niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
		
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	

}
