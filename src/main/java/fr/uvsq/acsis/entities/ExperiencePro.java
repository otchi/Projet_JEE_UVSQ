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
 *entité d'experience proffetionnel dans le cv d'un candidat
 */
@SuppressWarnings("serial")
@Entity
@Table(name="experience_pro")
public class ExperiencePro implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExperiencePro;

	private String nomEtablisement;

	private String dateDebut;
	private String dateFin;
	
	private String descrition;
	
	/**
	 * un cv contient plusieur experiencePro
	 */
	@ManyToOne
	@JoinColumn(name="id_curuculium")
	private Curuculium curuculium;
	
	
	public ExperiencePro() {
		super();
	
	}
	
	public ExperiencePro(String nomEtablisement, String dateDebut, String dateFin,String descrition) {
		super();
		this.nomEtablisement = nomEtablisement;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.descrition=descrition;
	}

	
	public Long getIdExperiencePro() {
		return idExperiencePro;
	}

	public void setIdExperiencePro(Long idExperiencePro) {
		this.idExperiencePro = idExperiencePro;
	}

	public String getNomEtablisement() {
		return nomEtablisement;
	}
	public void setNomEtablisement(String nomEtablisement) {
		this.nomEtablisement = nomEtablisement;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public Curuculium getCuruculium() {
		return curuculium;
	}

	public void setCuruculium(Curuculium curuculium) {
		this.curuculium = curuculium;
	}
	
	

}
