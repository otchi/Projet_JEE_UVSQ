package fr.uvsq.acsis.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.uvsq.acsis.dao.InstitueDAO;
import fr.uvsq.acsis.entities.InstituteFormation;

/**
 * 
 * @author amine
 *implementationde l'interface adminstratuer formation
 */
@Transactional
public class Admin implements IAdmin{

	InstitueDAO dao;

	public void setDao(InstitueDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addFormation(InstituteFormation formation) {
		dao.addIFormation(formation);
		
	}

	@Override
	public void removeFormation(Long idFormation) {
		dao.removeIFormation(idFormation);
		
	}

	@Override
	public void getFormation(Long idFormation) {
		dao.getInstituteFormation(idFormation);
		
	}

	@Override
	public void updateFormation(InstituteFormation formation) {
		dao.updateIFormation(formation);
		
	}

	@Override
	public List<InstituteFormation> allFormatios() {
		// TODO Auto-generated method stub
		return null;
	}
}
