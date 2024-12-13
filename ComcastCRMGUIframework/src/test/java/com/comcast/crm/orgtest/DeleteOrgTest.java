/*package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
		
		
		JavaUtility jLib = new JavaUtility();
		
		
			//Random r =new Random();
			//int count = r.nextInt(1000);
			ExcelUtility eLib = new ExcelUtility();
		String	orgname = eLib.getDataFromExcel("org", 10, 2)+ jLib.getRandomNumber();
			
			WebDriver driver = null;
			if(browser.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(browser.equals("firefox")) {
				driver=new FirefoxDriver();}
				else if(browser.equals("edge")) {
					driver=new EdgeDriver();
				}else {
					driver= new   ChromeDriver();
				}
			driver.get("http://localhost:8888/");
			LoginPage lp = new LoginPage(driver); 
			lp.logintoapp("admin", "admin");
			Thread.sleep(5000);
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
			//go back yo organisationpage
			h.getOrgpage().click();
			orgpg.getSearchEdt().sendKeys(orgname);
			WebDriverrUtility wLib = new WebDriverrUtility();
			wLib.select(orgpg.getSearchDd(),"Organization Name");
			orgpg.getSearchbtn().click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[text()='"+orgname+"'])[2]/../../td/a[text()='del']")).click();
			//driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
			//driver.findElement(By.xpath("//a[text()= '"+orgname+"']/../..//td[8]/a[2]"));
			//a[text()= 'Deepak_2305']/../..//td[8]/a[2]
			}
	}*/


