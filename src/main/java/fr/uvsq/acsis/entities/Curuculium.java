package fr.uvsq.acsis.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name="curuculium")
public class Curuculium implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCuruculium;

	@OneToMany(mappedBy="curuculium")
	private Collection<ExterneFormation> formations;
	@OneToMany(mappedBy="curuculium")
	private Collection<ExperiencePro> experiencePros;
	
	private String competance;
	@NotNull
	@OneToOne
	@JoinColumn(name="id_dossier")
	private Dossier dossier;
	

	public Curuculium() {
		super();

	}
	
	public Curuculium(Collection<ExterneFormation> formations, 
			Collection<ExperiencePro> experiencePros,String competance) {
		super();
		this.formations = formations;
		this.experiencePros = experiencePros;
		this.competance=competance;
	}

	
	public Long getIdCuruculium() {
		return idCuruculium;
	}

	public void setIdCuruculium(Long idCuruculium) {
		this.idCuruculium = idCuruculium;
	}

	public Collection<ExterneFormation> getFormations() {
		return formations;
	}
	public void setFormations(Collection<ExterneFormation> formations) {
		this.formations = formations;
	}
	public Collection<ExperiencePro> getExperiencePros() {
		return experiencePros;
	}
	public void setExperiencePros(Collection<ExperiencePro> experiencePros) {
		this.experiencePros = experiencePros;
	}
	
	public void addFormation(ExterneFormation formation){
		this.formations.add(formation);
		
	}
	
	public void addExperiencePro(ExperiencePro experiencePro){
		this.experiencePros.add(experiencePro);
		
	}

	public String getCompetance() {
		return competance;
	}

	public void setCompetance(String competance) {
		this.competance = competance;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
	
	
}
