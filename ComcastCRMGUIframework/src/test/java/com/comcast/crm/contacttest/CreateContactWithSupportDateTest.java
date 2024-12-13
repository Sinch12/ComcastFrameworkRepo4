 /*package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
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
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactpage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		//read data from property file
		//FileUtility fLib = new FileUtility();
		//String browser = fLib.getDataFromPropertiesFile("browser");
		//String url = fLib.getDataFromPropertiesFile("url");
		//String un = fLib.getDataFromPropertiesFile("username");
		//String pwd = fLib.getDataFromPropertiesFile("password");

		//JavaUtility jLib = new JavaUtility();

		//read data from excel file
		//ExcelUtility eLib = new ExcelUtility();
		String lastname = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNumber();
		HomePage h = new HomePage(driver);
		h.getContactlink().click();
		h.getImgcontact().click();
		CreateContactPage c = new CreateContactPage(driver);
		c.getContactedt().sendKeys(lastname);
		String startdate = jLib.getSystemDateYYYYDDMM();
		String enddate = jLib.getReqDateYYYYDDMM(+30);
		Thread.sleep(3000);
		CreatingNewContactpage cr = new CreatingNewContactpage(driver);
		Thread.sleep(3000);
		cr.getSupportstartdate().clear();
		cr.getSupportstartdate().sendKeys(startdate);
		cr.getSupportenddate().clear();
		cr.getSupportenddate().sendKeys(enddate);
		OrganizationsPage o = new OrganizationsPage(driver);
		o.getSaveorg().click();
		ContactInformationPage ci = new ContactInformationPage(driver);
		String actualdata = ci.getHeadermsg().getText();
		Thread.sleep(1000);
		if(actualdata.contains(lastname)) {
			System.out.println(lastname + "is created==pass");
		}else {
			System.out.println(lastname + "is not created==fail");
		}
	String actdate = ci.getStartedit().getText();
		if(actdate.trim().equals(startdate)) {
			System.out.println(startdate + "is created==pass");
		}else {
			System.out.println(startdate + "is not created==fail");

		}
	String	actenddate =ci.getEnddate().getText();
	if(actenddate.equals(enddate)) {
		System.out.println(enddate + "is verified");	
	}
	else
	{
		System.out.println(enddate +"is not verified");
		}
	
		//driver.close();
	}}
		//java.util.Date dateobj = new java.util.Date();  
		//System.out.println(dateobj.toString());
		//SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		////String startdate = s.format(dateobj);
		//System.out.println(startdate);

		//SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
		//Calendar cal = s.getCalendar();
		//cal.add(Calendar.DAY_OF_MONTH,+30);
		//String enddate = s .format(cal.getTime());
		//System.out.println(reqdate);
		
		//driver.findElement(By.name("support_start_date")).clear();
		//driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		//driver.findElement(By.name("support_end_date")).clear();
		//driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		/*driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(1000);
		String actdata = driver.findElement(By.xpath("//span[@class ='dvHeaderText']")).getText();
		if(actdata.contains(lastname)) {
			System.out.println(lastname + "is created and pass");
		}
		else
		{
			System.out.println(lastname + "is not created and fail");
			}
		String actstart = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstart.equals(startdate)) {
			System.out.println(startdate + "is verified");	
		}
		else
		{
			System.out.println(startdate +"is not verified");
			}
			String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actenddate.equals(enddate)) {
			System.out.println(enddate + "is verified");	
		}
		else
		{
			System.out.println(enddate +"is not verified");
			}
		driver.quit();
		
	}

}*/
