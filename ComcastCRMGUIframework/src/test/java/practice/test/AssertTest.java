package practice.test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {
     @Test
	public void HardAssert() {
    	 System.out.println("..........L1.....");
    	 System.out.println(".........L2.......");
    	Assert.assertEquals("a", "b");
    	System.out.println(".....L3....");
    	System.out.println(".....L4....");
    	
		

	}
     @Test
     public void SoftAssertt() {
    	 System.out.println("..........L1.....");
    	 System.out.println(".........L2.......");
    	 SoftAssert s = new SoftAssert();
    	 s.assertEquals("a", "b");
    	System.out.println(".....L3....");
    	System.out.println(".....L4....");
    	s.assertAll();
    	 
     }

}
