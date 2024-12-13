package com.comcast.crm.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.PricebookPage;

public class PriceBookTest {

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
			LoginPage l = new LoginPage(driver);
			l.logintoapp(url, un, pwd);	
			
			Actions a = new Actions(driver);
			WebElement mv = driver.findElement(By.linkText("More"));
			a.moveToElement(mv).perform();
			PricebookPage p = new PricebookPage(driver);
			p.getPricebook().click();
			p.getCreatePricebook().click();
			p.getBookedt().sendKeys(lastname);
			p.getSaveedt().click();
			String actdata = p.getVerifypr().getText();
			//driver.findElement(By.linkText("Price Books")).click();
			//driver.findElement(By.xpath("//img[@title='Create Price Book...']")).click();
			//driver.findElement(By.name("bookname")).sendKeys(lastname);
			//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			//String  actdata = driver.findElement(By.id("dtlview_Price Book Name")).getText();
			if(actdata.contains(lastname)) {
     			System.out.println(lastname + "is created==pass");
     		}else {
     			System.out.println(lastname + "is not created==fail");
     		}
			
			
	}

}
