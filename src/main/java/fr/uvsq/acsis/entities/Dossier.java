package fr.uvsq.acsis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@OneToOne
	@JoinColumn(name="id_cv")
	private Curuculium cv;
  
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
	
	
	
	

}
