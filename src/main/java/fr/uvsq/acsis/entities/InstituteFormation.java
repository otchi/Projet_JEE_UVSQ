package fr.uvsq.acsis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="institue_formation")
public class InstituteFormation extends Formation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInstFormation;
	private String description;
	
	public InstituteFormation(String nom, String niveau, Long idInstFormation, String description) {
		super(nom, niveau);
		this.idInstFormation = idInstFormation;
		this.description = description;
	}

	public Long getIdInstFormation() {
		return idInstFormation;
	}

	public void setIdInstFormation(Long idInstFormation) {
		this.idInstFormation = idInstFormation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
