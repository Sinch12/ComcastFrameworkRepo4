package com.comcast.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.InvoicePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Opportunitypage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;

public class InvoiceTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverrUtility wLib = new WebDriverrUtility();
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
		
		String orgname = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber();
			
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
			wLib.waitForPageToLoad(driver);
			//driver.get(url);
			//driver.findElement(By.name("user_name")).sendKeys(un);
			//driver.findElement(By.name("user_password")).sendKeys(pwd);
			//driver.findElement(By.id("submitButton")).click();
			LoginPage l = new LoginPage(driver);
			l.logintoapp(url, un, pwd);
			HomePage h = new HomePage(driver);
			h.Createorg();
			OrganizationsPage org = new OrganizationsPage(driver);
			org.getOrgname().sendKeys(orgname);
			org.getSaveorg().click();
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
			
			}
			ProductPage p = new ProductPage(driver);
			p.getProductedit().click();
			p.getCreateprod().click();
			p.getProdname().sendKeys(orgname);
			p.getSaveedit().click();
			String headerinfo1 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if(headerinfo1.contains(orgname)) {
				System.out.println(orgname + "is created==pass");
			}else {
				System.out.println(orgname + "is not created==fail");
			}
			String actorgname1 = driver.findElement(By.id("dtlview_Product Name")).getText();
			if(actorgname1.equals(orgname)) {
				System.out.println(orgname + "is created==pass");
			}else {
				System.out.println(orgname + "is not created==fail");
			}
			WebElement mv = driver.findElement(By.linkText("More"));
			wLib.mousemoveOnElement(driver, mv);
			InvoicePage i = new InvoicePage(driver);
			i.getInvoiceedit().click();
			i.getCreateinvoice().click();
			i.getSubedt().sendKeys(lastname);
			i.getSelectedt().click();
			wLib.switchToTabonURL(driver, "Accounts&action");
			i.getSearchedit().sendKeys(orgname);
			i.getSearchedt().click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			Alert a8 =driver.switchTo().alert();
			a8.accept();
			wLib.switchToTabonTitle(driver, "Invoice");	
			String startdate = jLib.getSystemDateYYYYDDMM();
		String reqdate = jLib.getReqDateYYYYDDMM(+30);
		i.getDateedit().clear();
		i.getDateedit().sendKeys(startdate);
		i.getDuedate().clear();
		i.getDuedate().sendKeys(reqdate);
		i.getBilledit().sendKeys("1000");
		driver.findElement(By.name("bill_street")).sendKeys("1000");
		i.getImgedit().click();
		wLib.switchToTabonURL(driver, "Accounts&action");
		Opportunitypage op = new Opportunitypage(driver);
		op.getSearchedt().sendKeys(orgname);
		op.getSearchedit().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		wLib.switchToTabonTitle(driver, "Invoice");
		i.getQuantityedt().sendKeys("1");
		i.getSaveedit().click();
		String headerinfo2 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(headerinfo2.contains(lastname)) {
			System.out.println(lastname + "is created==pass");
		}else {
			System.out.println(lastname + "is not created==fail");
		}
			
		
	}}	
			
		/*	WebElement mv = driver.findElement(By.linkText("More"));
			wLib.mousemoveOnElement(driver, mv);
			driver.findElement(By.linkText("Invoice")).click();
			driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
			driver.findElement(By.name("subject")).sendKeys(lastname);
			driver.findElement(By.xpath("(//img[@title='Select'])[3 ]")).click();
			wLib.switchToTabonURL(driver, "Accounts&action");
				driver.findElement(By.id("search_txt")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
				Thread.sleep(2000);			
			Alert a8 =driver.switchTo().alert();
			a8.accept();
			wLib.switchToTabonTitle(driver, "Invoice");	
			java.util.Date d = new java.util.Date();
			System.out.println(d.toString());
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String startdate = sim.format(d);
			System.out.println(startdate);
			Calendar s4 = sim.getCalendar();
			s4.add(Calendar.DAY_OF_MONTH,+30);
	String reqdate = sim.format(s4.getTime());
	System.out.println(reqdate);
	driver.findElement(By.name("invoicedate")).clear();
	driver.findElement(By.name("invoicedate")).sendKeys(startdate);
	driver.findElement(By.name("duedate")).clear();
	driver.findElement(By.name("duedate")).sendKeys(reqdate);
	driver.findElement(By.name("ship_street")).sendKeys("1000");
	driver.findElement(By.xpath("//img[@id ='searchIcon1']")).click();
	wLib.switchToTabonURL(driver, "Accounts&action");
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		Thread.sleep(2000);
		wLib.switchToTabonTitle(driver, "Invoice");
		driver.findElement(By.id("qty1")).sendKeys("1");
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	String headerinfo2 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(headerinfo2.contains(lastname)) {
		System.out.println(lastname + "is created==pass");
	}else {
		System.out.println(lastname + "is not created==fail");
	}
	}

}
*/