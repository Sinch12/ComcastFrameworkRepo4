/*package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		//create organisation
		FileUtility fLib = new FileUtility();
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
		

		JavaUtility jLib = new JavaUtility();
		WebDriverrUtility wLib = new WebDriverrUtility();
		
		
		ExcelUtility eLib = new ExcelUtility();
		String orgname = eLib.getDataFromExcel("contact", 7, 2)+ jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber();
		HomePage h = new HomePage(driver);
		h.Createorg();
		OrganizationsPage orgpg = new OrganizationsPage(driver);
		orgpg.createOrg1(orgname);
	  	OrganizationInformationPage orgin = new OrganizationInformationPage(driver);
		Thread.sleep(2000);
		String headermsg = orgin.getHeadermsg().getText();
		String actorgname = orgin.getActorgname().getText();
		if(headermsg.contains(orgname)) {
			System.out.println(orgname + "is created==pass");
		}else {
			System.out.println(orgname + "is not created==fail");
		}
		if(actorgname.equals(orgname)) {
			System.out.println(orgname + "is created==pass");
		}else {
			System.out.println(orgname + "is not created==fail");
		}
		h.getContactlink().click();
		h.getImgcontact().click();
		CreateContactPage c = new CreateContactPage(driver);
		c.getContactedt().sendKeys(lastname);
		c.getOrgclick().click();
		wLib.switchToTabonURL(driver, "module=Accounts");
		OrganizationsPage o = new OrganizationsPage(driver);
		o.getSearchtext().sendKeys(orgname);
		o.getSearchfield().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		wLib.switchToTabonTitle(driver, "Contacts&action");
		o.getSaveorg().click();
		wLib.switchToTabonTitle(driver, "Contacts&action");
		ContactInformationPage ci = new ContactInformationPage(driver);
		String headerinfo1 = ci.getHeadermsg().getText();
		Thread.sleep(1000);
		if(headerinfo1.contains(lastname)) {
			System.out.println(lastname + "is created==pass");
		}else {
			System.out.println(lastname + "is not created==fail");
		}
		String actorgname1 = ci.getOrganizationname().getText();
		if(actorgname1.trim().equals(orgname)) {
			System.out.println(orgname + "is created==pass");
		}else {
			System.out.println(orgname + "is not created==fail");

		}
		driver.close();
	}}*/
		