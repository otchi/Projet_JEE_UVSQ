package fr.uvsq.acsis.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="experience_pro")
public class ExperiencePro implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExperiencePro;
	@NotEmpty
	private String nomEtablisement;
	@NotEmpty
	private Date dateDebut;
	private Date dateFin;
	
	private String descrition;
	
	@ManyToOne
	@JoinColumn(name="id_curuculium")
	private Curuculium curuculium;
	
	
	public ExperiencePro() {
		super();
	
	}
	
	public ExperiencePro(String nomEtablisement, Date dateDebut, Date dateFin,String descrition) {
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
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
