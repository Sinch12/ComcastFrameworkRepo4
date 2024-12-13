package practice.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.script.ResultOwnership;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class SampleReportTest {
	public ExtentReports report;
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite results");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.DARK);
		
		//add env info and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		
	}
	@AfterSuite
	public void configAs() {
		 report.flush();
	}
	@Test
	public void createContactTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
	TakesScreenshot t = (TakesScreenshot)BaseClass.sdriver;
	String src = t.getScreenshotAs(OutputType.BASE64);
	ExtentTest test = report.createTest("createContactTest");
		 test.log(Status.INFO,"login to app");
		 test.log(Status.INFO,"navigate to contact page");
		 test.log(Status.INFO,"create contact");
		 if("Hdfc".equals("Hdc")) {
			 test.log(Status.PASS,"contact is created and pass");
		 }
		 else {
			 test.addScreenCaptureFromBase64String(src, "ErrorFile");
		 }
		 driver.close();
		
	}
	@Test
	public void createContactWithOrgTest() {
		
	ExtentTest test = report.createTest("createContactWithOrgTest");
	
		
		
		 test.log(Status.INFO,"login to app");
		 test.log(Status.INFO,"navigate to contact page");
		 test.log(Status.INFO,"create contact");
		 if("Hdfc".equals("Hdf")) {
			 test.log(Status.PASS,"contact is created and pass");
		 }
		 else {
			 test.log(Status.FAIL,"contact is not created and fail");
		 }
		 
	}
		 @Test
			public void createContactWithPhonenumTest() {
				
			ExtentTest test = report.createTest("createContactwithphonenumTest");
			
				
				
				 test.log(Status.INFO,"login to app");
				 test.log(Status.INFO,"navigate to contact page");
				 test.log(Status.INFO,"create contact");
				 if("Hdfc".equals("Hdfc")) {
					 test.log(Status.PASS,"contact is created and pass");
				 }
				 else {
					 test.log(Status.FAIL,"contact is not created and fail");
				 }
				
		
		 }

}
