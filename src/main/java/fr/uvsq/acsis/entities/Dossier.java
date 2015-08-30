package fr.uvsq.acsis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="dossier")
public class Dossier implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDossier;
	@NotEmpty
	private String motive;
	@OneToOne(mappedBy="dossier")
	private Curuculium cv;
	@NotNull
	@OneToOne
	@JoinColumn(name="id_candidat")
	private Candidat candidat;
  
	public Dossier(){
		super();
	}

	public Dossier(String motive) {
		super();
		this.motive = motive;
	}
	public Long getIdDossier() {
		return idDossier;
	}
	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}
	public Curuculium getCv() {
		return cv;
	}
	public void setCv(Curuculium cv) {
		this.cv = cv;
	}
	public String getMotive() {
		return motive;
	}
	public void setMotive(String motive) {
		this.motive = motive;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	
	
	
	

}
