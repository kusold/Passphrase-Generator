package cse551.Passwordgenerator;

import junit.framework.TestCase;
import cse551.Passwordgenerator.GeneratePassword;
public class GeneratePasswordTests extends TestCase {
	public void outIdenticalResults() {
		GeneratePassword gen = new GeneratePassword();
		
		String testA = new String();
		String testB = new String();
		testA = gen.generateAlphaNumPassword("This Brown Fox");
		testB = gen.generateAlphaPassword("This Brown Fox");
		
		assertEquals(testA, testB);
	}

}
