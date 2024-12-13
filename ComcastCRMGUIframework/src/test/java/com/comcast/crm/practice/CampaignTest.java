package com.comcast.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CampaignTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
		/*FileInputStream fis = new FileInputStream(".\\configAppData\\integration.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		//System.out.println(browser);
		String url = p.getProperty("url");
		//System.out.println(url);
		String un = p.getProperty("username");
		//System.out.println(un);
		String pwd = p.getProperty("password");
		//System.out.println(pwd);
				
			Random r =new Random();
			int count = r.nextInt(1000);*/
			String lastname = eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
			//FileInputStream fis1 = new FileInputStream(".\\testdata\\testScriptdata3.xlsx");
			//Workbook wb = WorkbookFactory.create(fis1);
			//Sheet sh = wb.getSheet("contact");
			//Row row = sh.getRow(1);
			//String lastname = row.getCell(2).getStringCellValue()+jLib.getRandomNumber();
			//System.out.println(lastname);
	
			
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
			driver.findElement(By.name("user_name")).sendKeys(un);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.id("submitButton")).click();
			Actions a = new Actions(driver);
			WebElement mv = driver.findElement(By.linkText("More"));
			a.moveToElement(mv).perform();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			driver.findElement(By.name("campaignname")).sendKeys(lastname);
			
			driver.findElement(By.id("jscal_trigger_closingdate")).click();
			Thread.sleep(2000);
			java.util.Date d = new java.util.Date();
			System.out.println(d.toString());
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String startdate = sim.format(d);
			System.out.println(startdate);
			Calendar s4 = sim.getCalendar();
			s4.add(Calendar.DAY_OF_MONTH,+30);
	String reqdate = sim.format(s4.getTime());
	System.out.println(reqdate);
	driver.findElement(By.id("jscal_trigger_closingdate")).sendKeys(reqdate);
	
			Actions a1 = new Actions(driver);
			//WebElement date = driver.findElement("(//td[@class="day selected"])[7]");
			//a.moveToElement(date).click().perform();
			//driver.findElement(By.id("phone")).sendKeys(phonenum);
			//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

	}

}
