/*package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateorgWithPhonenum {

	public static void main(String[] args) throws InterruptedException, Throwable {
		FileUtility fLib = new FileUtility();
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
		
				
			
			JavaUtility jLib = new JavaUtility();
			ExcelUtility eLib = new ExcelUtility();
			String orgname = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
		   String phonenum = eLib.getDataFromExcel("org", 7, 3);
			
			
			//String phonenum = row.getCell(3).getStringCellValue().toString();
		
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
			driver.get("http://localhost:8888/");
			LoginPage l = new LoginPage(driver);
			l.logintoapp(un, pwd);
			HomePage h = new HomePage(driver);
			h.Createorg();
			OrganizationsPage o = new OrganizationsPage(driver);
			o.createOrg2(orgname, phonenum);
			OrganizationInformationPage oin = new OrganizationInformationPage(driver);
			Thread.sleep(1000);
			String actphn = oin.getActphnnum().getText();
			if(actphn.contains(phonenum)) {
				System.out.println(phonenum + "is created==pass");
			}else {
				System.out.println(phonenum + "is not created==fail");
			}	
	}}	
			/*driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.id("phone")).sendKeys(phonenum);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(3000);
			String actphn = driver.findElement(By.id("dtlview_Phone")).getText();
			if(actphn.contains(phonenum)) {
				System.out.println(phonenum + "is created==pass");
			}else {
				System.out.println(phonenum + "is not created==fail");
			}}}
			/*String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actorgname.equals(data)) {
				System.out.println(data + "is created==pass");
			}else {
				System.out.println(data + "is not created==fail");
	}

}

	private static Object getRow(int i) {
		// TODO Auto-generated method stub
		return null;
	}}*/
