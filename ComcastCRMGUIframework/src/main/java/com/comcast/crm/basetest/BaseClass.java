package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.LogoutPage;

public class BaseClass {
	public	DataBaseUtility dbLib = new DataBaseUtility();
	public  ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public  JavaUtility jLib = new JavaUtility();
	public WebDriverrUtility wLib = new WebDriverrUtility();
	public WebDriver driver = null;
	public static  WebDriver sdriver = null;
	

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		System.out.println("connect to db,report config");
		dbLib.getDbconnection();
	

	}
	//getting the parameter from xml
     /* @Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(String browser) throws Throwable {
		System.out.println("launch the browser");
		//String BROWSER = browser;
				//fLib.getDataFromPropertiesFile("browser");*/
		
		@BeforeClass(alwaysRun = true)
		public void configBC() throws Throwable {
			System.out.println("launch the browser");
			String browser = fLib.getDataFromPropertiesFile("browser");

		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
sdriver=driver;
UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		System.out.println("login"); 
		String url = fLib.getDataFromPropertiesFile("url");
		String username = fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");
		System.out.println("URL:"+url+" un:"+username+" pwd:"+password);
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp(url,username, password);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		System.out.println("logout");
		LogoutPage lo = new LogoutPage(driver);
		lo.getLogout();

		//HomePage h = new HomePage(driver);

	}
	@AfterClass(alwaysRun = true)
	public void configAC() {
 
		driver.quit();

	}
	@AfterSuite(alwaysRun = true)
	public void configAS() {
		System.out.println("close Db,report backup");
		dbLib.closeDbconnection();
		 
	}

}

