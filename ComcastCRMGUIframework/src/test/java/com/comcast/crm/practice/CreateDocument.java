package com.comcast.crm.practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.DocumentPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Opportunitypage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.PricebookPage;

import junit.framework.Assert;
@Listeners(com.comcast.crm.listenerutility.ListenerImp.class)
/**
 * @author Sinchana K S
 */
public class CreateDocument extends BaseClass {

	@Test (priority = 1,retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void createDoc() throws Throwable{	
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
String lastname = eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
UtilityClassObject.getTest().log(Status.INFO, "navigate to document page");
			DocumentPage d = new DocumentPage(driver);
			d.getDocedit().click();
			d.getCreatedoc().click();
			d.getTitledit().sendKeys(lastname);
			d.getSavedit().click();
			UtilityClassObject.getTest().log(Status.INFO, lastname + "create a doucument");
			String actlname = d.getHeadermsg().getText();
			boolean status = actlname.contains(lastname);
			Assert.assertEquals(status, true); 
			/*if(actlname.contains(lastname)) {
				System.out.println(actlname + "is created==pass");
			}else {
				System.out.println(actlname + "is not created==fail");*/
	}
			@Test(priority = 2,retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
			public void CreateOppurtunity() throws Throwable {
				UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
				String orgname = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
				wLib.waitForPageToLoad(driver);
				UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
				HomePage h = new HomePage(driver);
				h.Createorg();
				UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
				OrganizationsPage orgpg = new OrganizationsPage(driver);
				orgpg.createOrg1(orgname);
			  	OrganizationInformationPage orgin = new OrganizationInformationPage(driver);
			  	UtilityClassObject.getTest().log(Status.INFO,orgname + "create an oppurtunity");
				String headermsg = orgin.getHeadermsg().getText();
			boolean status = headermsg.contains(orgname);
			Assert.assertEquals(status, true);
			
			UtilityClassObject.getTest().log(Status.INFO,orgname + "create an oppurtunity");
				String actorgname = orgin.getActorgname().getText();
				boolean status1 = actorgname.contains(orgname);
				Assert.assertEquals(status1, true);
				/*if(headermsg.contains(orgname)) {
					System.out.println(orgname + "is created==pass");
				}else {
					System.out.println(orgname + "is not created==fail");
				}
				if(actorgname.equals(orgname)) {
					System.out.println(orgname + "is created==pass");
				}else {
					System.out.println(orgname + "is not created==fail");
				}*/
				Opportunitypage op = new Opportunitypage(driver);
				op.getOpportunityedt().click();
				op.getCreateopr().click();
				op.getNameedit().sendKeys(orgname);
				op.getOrgbtn().click();
				wLib.switchToTabonURL(driver, "Accounts&action");
				String url1=driver.getCurrentUrl();
				System.out.println(url1);
				op.getSearchedt().sendKeys(orgname);
				op.getSearchedit().click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
					wLib.switchToTabonTitle(driver, "Opportunities");
					op.getRadiobtn().click();
					op.select("Support Group");
					op.getSaveorg().click();
					UtilityClassObject.getTest().log(Status.INFO,orgname + "create an oppurtunity");
				String	headerinfo1 =op.getHeaderinfo().getText();
			boolean status2 = headerinfo1.contains(orgname);
			Assert.assertEquals(status2, true);
				/*if(headerinfo1.contains(orgname)) {
	     			System.out.println(orgname + "is created==pass");
	     		}else {
	     			System.out.println(orgname + "is not created==fail");
	     		}	*/				
			}
			@Test(priority = 3,retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
			public void CreateInvoice() throws Throwable {
				UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
				String orgname = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
				UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
				HomePage h = new HomePage(driver);
				h.Createorg();
				UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
				OrganizationsPage orgpg = new OrganizationsPage(driver);
				orgpg.createOrg1(orgname);
			  	OrganizationInformationPage orgin = new OrganizationInformationPage(driver);
				UtilityClassObject.getTest().log(Status.INFO,orgname + "create an oppurtunity");
				String headermsg = orgin.getHeadermsg().getText();
				boolean status = headermsg.contains(orgname);
				Assert.assertEquals(status, true);
				UtilityClassObject.getTest().log(Status.INFO,orgname + "create an oppurtunity");
				String actorgname = orgin.getActorgname().getText();
			boolean status2 = actorgname.contains(orgname);
			Assert.assertEquals(status2, true);
				
				/*if(headermsg.contains(orgname)) {
					System.out.println(orgname + "is created==pass");
				}else {
					System.out.println(orgname + "is not created==fail");
				}
				if(actorgname.equals(orgname)) {
					System.out.println(orgname + "is created==pass");
				}else {
					System.out.println(orgname + "is not created==fail");
				}*/
			UtilityClassObject.getTest().log(Status.INFO,orgname + "navigate to invoice  page");
				Opportunitypage op = new Opportunitypage(driver);
				op.getOpportunityedt().click();
				op.getCreateopr().click();
				op.getNameedit().sendKeys(orgname);
				op.getOrgbtn().click();
				wLib.switchToTabonURL(driver, "Accounts&action");
				String url1=driver.getCurrentUrl();
				System.out.println(url1);
				op.getSearchedt().sendKeys(orgname);
				op.getSearchedit().click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
					wLib.switchToTabonTitle(driver, "Opportunities");
					op.getRadiobtn().click();
					op.select("Support Group");
					op.getSaveorg().click();
					UtilityClassObject.getTest().log(Status.INFO,orgname + "create an invoice");
				String	headerinfo1 =op.getHeaderinfo().getText();
			boolean status3 = headerinfo1.contains(orgname);
			Assert.assertEquals(status3, true);
				/*if(headerinfo1.contains(orgname)) {
	     			System.out.println(orgname + "is created==pass");
	     		}else {
	     			System.out.println(orgname + "is not created==fail");
	     		}*/
			}
				
				@Test(groups = {"smokeTest","regressionTest"},retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
				public void createPricebook() throws Throwable {
					UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
					String lastname = eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
					Actions a = new Actions(driver);
					WebElement mv = driver.findElement(By.linkText("More"));
					a.moveToElement(mv).perform();
					UtilityClassObject.getTest().log(Status.INFO,"navigate to pricebook page");
					PricebookPage p = new PricebookPage(driver);
					p.getPricebook().click();
					p.getCreatePricebook().click();
					p.getBookedt().sendKeys(lastname);
					p.getSaveedt().click();
					UtilityClassObject.getTest().log(Status.INFO,lastname + "create an invoice");
					String actdata = p.getVerifypr().getText();
					boolean status4 = actdata.contains(lastname);
					Assert.assertEquals(status4, true);
					
				/*	if(actdata.contains(lastname)) { 
		     			System.out.println(lastname + "is created==pass");
		     		}else {
		     			System.out.println(lastname + "is not created==fail");
		     		}*/
					
				}
				
			}

		
