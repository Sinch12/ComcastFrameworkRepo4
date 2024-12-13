package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author Sinchana K S
 */
 
 
public class SeaechContactTest extends BaseClass{
	@Test
	public void searchcontactTest() {
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp("url", "un", "pwd");
	}
	

}
