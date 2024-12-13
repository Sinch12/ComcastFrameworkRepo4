package com.comcast.crm.practice;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Opportunitypage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class OppurtunityModule {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverrUtility wLib = new WebDriverrUtility(); 
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
			String orgname = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
			 WebDriver driver = null;
			if(browser.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(browser.equals("firefox")) {
				driver=new FirefoxDriver();}
				else if(browser.equals("edge")) {
					driver=new EdgeDriver();
				}else {
					driver= new ChromeDriver();
				}
			
			wLib.waitForPageToLoad(driver);
			LoginPage l = new LoginPage(driver);
			l.logintoapp(url, un, pwd);
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
				Thread.sleep(2000);
				wLib.switchToTabonTitle(driver, "Opportunities");
				op.getRadiobtn().click();
				op.select("Support Group");
				op.getSaveorg().click();
			String	headerinfo1 =op.getHeaderinfo().getText();
			if(headerinfo1.contains(orgname)) {
     			System.out.println(orgname + "is created==pass");
     		}else {
     			System.out.println(orgname + "is not created==fail");
     		}
			
  		
	}}
         	
			
			

	

			
