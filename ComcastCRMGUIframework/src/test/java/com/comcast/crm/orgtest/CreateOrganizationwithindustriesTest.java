/*package com.comcast.crm.orgtest;

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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationwithindustriesTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
		
				
			JavaUtility jLib = new JavaUtility();
			
			ExcelUtility eLib = new ExcelUtility();
			String cell = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNumber();
			String industry = eLib.getDataFromExcel("org", 4, 3);
			String type = eLib.getDataFromExcel("org", 4, 4);
			
			//FileInputStream fis1 = new FileInputStream(".\\testdata\\testScriptdata3.xlsx");
			//Workbook wb = WorkbookFactory.create(fis1);
			 //Sheet sh = wb.getSheet("org");
					//Row row = sh.getRow(4);
					//String cell = row.getCell(2).getStringCellValue();
					//String industry = row.getCell(3).getStringCellValue();
					//String type = row.getCell(4).getStringCellValue();
			//wb.close();
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
			LoginPage lp = new LoginPage(driver);
			lp.logintoapp(un, pwd);
			HomePage h = new HomePage(driver);
			h.Createorg();
			OrganizationsPage org = new OrganizationsPage(driver);
			//org.getCreateorg1().sendKeys(cell);
			org.createOrg1(cell, industry, type);
			OrganizationInformationPage orinpg = new OrganizationInformationPage(driver);
			Thread.sleep(1000);
			String actindname = orinpg.getActindname().getText();
			if(actindname.equals(industry)) {
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
	}}
			
			/*driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(cell);
			WebElement ind = driver.findElement(By.name("industry"));
			Select s = new Select(ind);
			s.selectByVisibleText(industry);
			
			WebElement ind1 = driver.findElement(By.name("accounttype"));
			Select s1 = new Select(ind1);
			s1.selectByVisibleText(type);
			
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(2000);
			String actindname = driver.findElement(By.id("dtlview_Industry")).getText();
			if(actindname.equals(industry)) {
				System.out.println(industry + "is created==pass");
			}else {
				System.out.println(industry + "is not created==fail");
	}
			String acttype = driver.findElement(By.id("dtlview_Type")).getText();
			if(acttype.equals(type)) {
				System.out.println(type + " is verified==pass");
			}else {
				System.out.println(type + " is not verified==fail");
			
	}}	}
			/*String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(cell)) {
				System.out.println(cell + "is created==pass");
			}else {
				System.out.println(cell + "is not created==fail");
			}
			String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actorgname.equals(cell)) {
				System.out.println(cell + "is created==pass");
			}else {
				System.out.println(cell + "is not created==fail");
	}

}}*/
