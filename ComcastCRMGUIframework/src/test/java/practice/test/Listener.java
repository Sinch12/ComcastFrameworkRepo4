package practice.test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import junit.framework.Assert;
//@Listeners(com.comcast.crm.listenerutility.ListenerImp.class)
public class Listener extends BaseClass {
@Test
public void createInvoiceTest() {
	System.out.println("execute createInvoiceTest");
	String var = driver.getTitle();
	Assert.assertEquals(var, "Login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
@Test 
public void createInvoicewithContactTest() {
	System.out.println("execute createInvoicewithContactTest");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
	
}
}
