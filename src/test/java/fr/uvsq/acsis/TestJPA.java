package fr.uvsq.acsis;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.uvsq.acsis.entities.Candidat;
import fr.uvsq.acsis.entities.InstituteFormation;
import fr.uvsq.acsis.metier.IAdmin;
import fr.uvsq.acsis.metier.I_Internaute;

/**
 * 
 * @author amine
 *teste du cantext application et JPA
 */
public class TestJPA {
	ClassPathXmlApplicationContext context;
	
	@Test
	public void test() {
		try{
			 context=new ClassPathXmlApplicationContext(
					 new String[]{"applicationContext.xml"});
			 
			/* IAdmin admin=(IAdmin) context.getBean("metier_admin");
			 admin.addFormation(new InstituteFormation("ccddddd", "m1dddddd", "tu fait tout"));
			 */
			 I_Internaute metierInt=(I_Internaute) context.getBean("metier_internaute");
			 context.getBean("metier_candidature");
			 metierInt.createCandidature(new Candidat("OUCHIHA", "Amine otchi", "09/09/1992", "amineouchiha@hotmail.com"));
			// metierInt.autentification("amine@gmail.com", "tGItYhk");
			// admin.addFormation(new InstituteFormation("ccccc", "tttt", "dddd"));
			 Assert.assertTrue(true);
		}catch(Exception e){
			Assert.assertTrue(e.getMessage(), false);
			
			
		}
	}

}
