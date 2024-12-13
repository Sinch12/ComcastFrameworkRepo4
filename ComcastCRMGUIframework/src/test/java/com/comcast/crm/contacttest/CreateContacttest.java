package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactpage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.LogoutPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImp.class)
/**
 * @author Sinchana K S 
 */
public class CreateContacttest extends BaseClass {

	@Test(priority = 1,groups = {"smokeTest","regressionTest"},retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void createContactTest() throws Throwable {	
		System.out.println("createContactTest");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String	lastname =eLib.getDataFromExcel("contact", 1, 2)+ jLib.getRandomNumber();
		System.out.println(lastname); 
        UtilityClassObject.getTest().log(Status.INFO, "navigate to contact PAGE");
		HomePage h = new HomePage(driver);
		h.getContactlink().click();
		h.getImgcontact().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new contact page");
		CreateContactPage c = new CreateContactPage(driver);
		c.getContactedt().sendKeys(lastname);
		c.getSaveedt().click();
		ContactInformationPage cin = new ContactInformationPage(driver);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO,lastname + "create a new contact");
		   String actHeader = cin.getHeadermsg().getText();  
		//String actHeader=driver.findElement(By.className("dvHeaderText")).getText();
		boolean status =actHeader.contains(lastname);//since the data is dynamic we use contains
		Assert.assertEquals(status,true); 
		String actlastname = cin.getLastnameedit().getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(actlastname, lastname);
		s.assertAll();
	 	//	System.out.println(actHeader + "is created==pass");
		//else {
			//System.out.println(actualname + "is not created==fail");
		//}
	}
	
	@Test (priority = 2,groups = "regressionTest",retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void CreateContactWithsupportDateTest() throws Throwable {
		System.out.println("CreateContactWithsupportDateTest");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastname = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage h = new HomePage(driver);
		h.getContactlink().click();
		h.getImgcontact().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		CreateContactPage c = new CreateContactPage(driver);
		c.getContactedt().sendKeys(lastname);
		UtilityClassObject.getTest().log(Status.INFO, "read data from javautility");
		String startdate = jLib.getSystemDateYYYYDDMM();
		String enddate = jLib.getReqDateYYYYDDMM(+30);
		Thread.sleep(3000);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		CreatingNewContactpage cr = new CreatingNewContactpage(driver);
		Thread.sleep(3000);
		cr.getSupportstartdate().clear();
		cr.getSupportstartdate().sendKeys(startdate);
		cr.getSupportenddate().clear();
		cr.getSupportenddate().sendKeys(enddate);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org");
		OrganizationsPage o = new OrganizationsPage(driver);
		o.getSaveorg().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact information");
		ContactInformationPage ci = new ContactInformationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,lastname + "create contact with supportdate");
		String actualdata = ci.getHeadermsg().getText();
		Thread.sleep(1000);
		boolean status = actualdata.contains(lastname);
		Assert.assertEquals(status, true);
		//if(actualdata.contains(lastname)) {
			//System.out.println(lastname + "is created==pass");
		//}else {
				//System.out.println(lastname + "is not created==fail");
			//}
		UtilityClassObject.getTest().log(Status.INFO, startdate + "create contact with enddate");
		String actdate = ci.getStartedit().getText();
		boolean status1 = actdate.contains(startdate);
		Assert.assertEquals(status1,true); 
				//System.out.println(startdate + "is created==pass");
		//}//else {
				//System.out.println(startdate + "is not created==fail");
			//}
		UtilityClassObject.getTest().log(Status.INFO, enddate + "create contact with enddate");
		String	actenddate =ci.getEnddate().getText();
		boolean status2 = actenddate.contains(enddate);
		Assert.assertEquals(status2,true); }
			//System.out.println(enddate + "is verified");	
		//}
		//else
		//{
			//System.out.println(enddate +"is not verified");
		//}
	
	@Test(priority = 3,groups = "regressionTest",retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void CreateContactWithOrgTest() throws Throwable {
		System.out.println("CreateContactWithOrgTest");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgname = eLib.getDataFromExcel("contact", 7, 2)+ jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage h = new HomePage(driver);
		h.Createorg();
		OrganizationsPage orgpg = new OrganizationsPage(driver);
		orgpg.createOrg1(orgname);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
	  	OrganizationInformationPage orgin = new OrganizationInformationPage(driver);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO,orgname + "create a new org");
		String headermsg = orgin.getHeadermsg().getText();
		System.out.println(headermsg);
		System.out.println(orgname);
		boolean status = headermsg.contains(orgname);
		System.out.println(status);
		Assert.assertEquals(status,true);
		UtilityClassObject.getTest().log(Status.INFO, orgname + "create a new org");
		String actorgname = orgin.getActorgname().getText();
		boolean status1 = actorgname.contains(orgname);
		System.out.println(status1);
		Assert.assertEquals(status1,true);
		
		h.getContactlink().click();
		h.getImgcontact().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact");
		CreateContactPage c = new CreateContactPage(driver);
		c.getContactedt().sendKeys(lastname);
		c.getOrgclick().click();
		wLib.switchToTabonURL(driver, "module=Accounts");
		UtilityClassObject.getTest().log(Status.INFO, "navigate to orgpagee");
		OrganizationsPage o = new OrganizationsPage(driver);
		o.getSearchtext().sendKeys(orgname);
		o.getSearchfield().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click(); 
		wLib.switchToTabonTitle(driver, "Contacts&action");
		o.getSaveorg().click();
		wLib.switchToTabonTitle(driver, "Contacts&action");
		ContactInformationPage ci = new ContactInformationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, lastname + "create a contact");
		String headerinfo1 = ci.getHeadermsg().getText();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO,lastname + "create a contact");
		boolean status2 = headerinfo1.contains(lastname);
		Assert.assertEquals(status2, true);
		/*if(headerinfo1.contains(lastname)) {
			System.out.println(lastname + "is created==pass");
		}else {
			System.out.println(lastname + "is not created==fail");
		}
		String actorgname1 = ci.getOrganizationname().getText();
		if(actorgname1.trim().equals(orgname)) {
			System.out.println(orgname + "is created==pass");
		}else {
			System.out.println(orgname + "is not created==fail");

		}*/
		
	}}
	
 
