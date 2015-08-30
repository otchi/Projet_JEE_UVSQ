package fr.uvsq.acsis.metier;

import org.springframework.transaction.annotation.Transactional;

import fr.uvsq.acsis.dao.InstitueDAO;

@Transactional
public class PurgeDataBase implements IPurgeDataBase {
	private InstitueDAO dao;
	@Override
	public void purgeDataBase() {
		// TODO Auto-generated method stub
		dao.purgeDataBase();
	}
	public void setDao(InstitueDAO dao) {
		this.dao = dao;
	}
	
}
