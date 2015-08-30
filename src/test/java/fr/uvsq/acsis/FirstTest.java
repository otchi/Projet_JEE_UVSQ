package fr.uvsq.acsis;

import org.junit.Assert;
import org.junit.Test;

import fr.uvsq.acsis.entities.Role;

public class FirstTest {
	
	@Test
	public void test(){
		Role r=new Role("tt");
		Assert.assertEquals(r.getRole(), "tt");
		
		
	}

}
