package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImp;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
/**
 * @author Sinchana K S
 */
@Listeners(com.comcast.crm.listenerutility.ListenerImp.class)
public class CreateOrganizationTest extends BaseClass {
@Test(priority = 1,groups = "smokeTest",retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void CreateOrg() throws Throwable {
		System.out.println("createorg");
		//FileUtility fLib = new FileUtility();
		//String browser = fLib.getDataFromPropertiesFile("browser");
		//String url = fLib.getDataFromPropertiesFile("url");
		//String un = fLib.getDataFromPropertiesFile("username");
		//String pwd = fLib.getDataFromPropertiesFile("password");4
		
		
		//JavaUtility jLib = new JavaUtility();
		
		
			//Random r =new Random();
			//int count = r.nextInt(1000);
			//ExcelUtility eLib = new ExcelUtility();
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String	orgname = eLib.getDataFromExcel("org", 1, 2)+ jLib.getRandomNumber();
			
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
			HomePage h = new HomePage(driver);
			h.Createorg();
			UtilityClassObject.getTest().log(Status.INFO, "create organization page");
			OrganizationsPage orgpg = new OrganizationsPage(driver);
			orgpg.createOrg1(orgname);
		  	OrganizationInformationPage orgin = new OrganizationInformationPage(driver);
			Thread.sleep(2000);
			String actHeader = orgin.getHeadermsg().getText();
			UtilityClassObject.getTest().log(Status.INFO,  orgname+"create a new org");

			boolean status =actHeader.contains(orgname);//since the data is dynamic we use contains
			Assert.assertEquals(true,status); 
			String actorgname = orgin.getActorgname().getText();
			SoftAssert s = new SoftAssert();
			s.assertEquals(actorgname, orgname);
			s.assertAll();
			
}
			/*if(headermsg.contains(orgname)) {
				System.out.println(orgname + "is created==pass");
			}else {
				System.out.println(orgname + "is not created==fail");
			}
			if(actorgname.equals(orgname)) {
				System.out.println(orgname + "is created==pass");
			}else {
				System.out.println(orgname + "is not created==fail");
			}}
			//driver.findElement(By.linkText("Organizations")).click();
			//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			//driver.findElement(By.name("accountname")).sendKeys(data);
			//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			/*Thread.sleep(3000);
			String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(orgname)) {
				System.out.println(orgname + "is created==pass");
			}else {
				System.out.println(orgname + "is not created==fail");
			}
			String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actorgname.equals(orgname)) {
				System.out.println(orgname + "is created==pass");
			}else {
				System.out.println(orgname + "is not created==fail");
			*/
			
			
			
			//Actions a = new Actions(driver);
			//a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			//Thread.sleep(2000);
			//driver.findElement(By.linkText("Sign Out")).click();
	

//span[@class='dvHeaderText']
@Test(priority = 2,groups = "regressionTest",retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
public void CreateOrgWithIndustry() throws Throwable {
	System.out.println("createOrgWithInd");
	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	String cell = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNumber();
	String industry = eLib.getDataFromExcel("org", 4, 3);
	String type = eLib.getDataFromExcel("org", 4, 4);
	UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
	HomePage h = new HomePage(driver);
	h.Createorg();
	UtilityClassObject.getTest().log(Status.INFO, "create organization page");
	OrganizationsPage org = new OrganizationsPage(driver);
	//org.getCreateorg1().sendKeys(cell);
	org.createOrg1(cell, industry, type);
	OrganizationInformationPage orinpg = new OrganizationInformationPage(driver);
	Thread.sleep(1000);
	String actindname = orinpg.getActindname().getText();
	UtilityClassObject.getTest().log(Status.INFO, industry+"create a new org");
	boolean status = actindname.contains(industry);
	Assert.assertEquals(status, true);
	String actType = orinpg.getActtype().getText();
	UtilityClassObject.getTest().log(Status.INFO,  type +"create a new org");
	SoftAssert s = new SoftAssert();
	s.assertEquals(actType, type);
	s.assertAll();
	//boolean status1 = actType.contains(type);
	//Assert.assertEquals(status1, false);
}
	/*if(actindname.equals(industry)) {
		System.out.println(industry + "is created==pass");
	}else {
		System.out.println(industry + "is not created==fail");
}
	String acttype = orinpg.getActtype().getText();
	if(acttype.equals(type)) {
		System.out.println(type + " is verified==pass");
	}else {
		System.out.println(type + " is not verified==fail");
	}			
}*/
@Test(priority = 3,groups = "regressionTest",retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class) 
public void CreateOrgWithPhonenum() throws Throwable {
	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	String orgname = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
	   String phonenum = eLib.getDataFromExcel("org", 7, 3);
	   UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
	   HomePage h = new HomePage(driver);
		h.Createorg();
		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		OrganizationsPage o = new OrganizationsPage(driver);
		o.createOrg2(orgname, phonenum);
		OrganizationInformationPage oin = new OrganizationInformationPage(driver);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, phonenum +"create new org");
		String actphn = oin.getActphnnum().getText();
	boolean status = actphn.contains(phonenum);
	Assert.assertEquals(status, true);
		/*if(actphn.contains(phonenum)) {
			System.out.println(phonenum + "is created==pass");
		}else {
			System.out.println(phonenum + "is not created==fail");
		}	*/
}}

