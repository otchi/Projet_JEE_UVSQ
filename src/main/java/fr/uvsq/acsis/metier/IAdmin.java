package fr.uvsq.acsis.metier;


import java.util.List;

import fr.uvsq.acsis.entities.InstituteFormation;
/**
 * 
 * @author amine
 * interface d'un administrateur des formation autentifié
 */
public interface IAdmin {
	public void addFormation(InstituteFormation formation);
	public void removeFormation(Long idFormation);
	public void getFormation(Long idFormation);
	public void updateFormation(InstituteFormation formation);
	public List<InstituteFormation> allFormatios();

}
