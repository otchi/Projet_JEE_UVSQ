package fr.uvsq.acsis.entities;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="externe_formation")
public class ExterneFormation extends Formation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExtFormation;
	private Year annee;
	@NotEmpty
	@Size(min=10,max=50)
	private String etablissement;
	@NotEmpty
	@Size(min=4,max=15)
	private String pays;
	
	@ManyToOne
	@JoinColumn(name="id_curuculium")
	private Curuculium curuculium;
	
	
	public ExterneFormation(String nom, String niveau, Long idExtFormation, Year annee, String etablissement,
			String pays) {
		super(nom, niveau);
		this.idExtFormation = idExtFormation;
		this.annee = annee;
		this.etablissement = etablissement;
		this.pays = pays;
	}


	public Long getIdExtFormation() {
		return idExtFormation;
	}


	public void setIdExtFormation(Long idExtFormation) {
		this.idExtFormation = idExtFormation;
	}


	public Year getAnnee() {
		return annee;
	}


	public void setAnnee(Year annee) {
		this.annee = annee;
	}


	public String getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public Curuculium getCuruculium() {
		return curuculium;
	}


	public void setCuruculium(Curuculium curuculium) {
		this.curuculium = curuculium;
	}
	
	


}
