package fr.uvsq.acsis;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
	ClassPathXmlApplicationContext context;
	@Test
	public void test() {
		//fail("Not yet implemented");
		try{
			 context=new ClassPathXmlApplicationContext(
					 new String[]{"applicationContext.xml"});
			 //I_Internaute metierInt=(I_Internaute) context.getBean("metier_internaute");
			 //ICandidature metierCandicat=(ICandidature) context.getBean("metier_candidature");
			// metier.createCandidature(new Candidat("OUCHIHA", "Amine", new Date(), "amine@gmail.com"));
			//metier.changePassword("amine@gmail.com");
			/* Long idCand;
			 System.out.println(
			 metierCandicat.getCandidature(idCand=metierInt.autentification("amine@gmail.com", "Ekugen"))
			 );/*
			 Dossier d=new Dossier("je suis motivé");
			 d.setMotive("je suis tre");
			 metierCandicat.createDossier(d,idCand);
			 Curuculium c=new Curuculium();
			 metierCandicat.createCuruculium(c, d.getIdDossier());*/
		//	 PurgeDataBase purge=(PurgeDataBase) context.getBean("purge_data_base");
			 /*purge.purgeDataBase();
			 */
			 //metierCandicat.c
			 //IPurgeDataBase purge=(IPurgeDataBase) context.getBean("metier_purge");
			 //purge.purgeDataBase();
			 
			 
			 Assert.assertTrue(true);
		}catch(Exception e){
			Assert.assertTrue(e.getMessage(), false);
			
			
		}
	}

}
