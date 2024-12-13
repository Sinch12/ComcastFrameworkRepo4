package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImp implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
System.out.println("Report configuration");
String time = new Date().toString().replace(" ", "_").replace(":", "_");
ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html"); 
spark.config().setDocumentTitle("CRM test suite results");
spark.config().setReportName("CRM REPORT");
spark.config().setTheme(Theme.DARK);

//add env info and create test
 report = new ExtentReports();
report.attachReporter(spark);
report.setSystemInfo("OS", "windows-10");
report.setSystemInfo("BROWSER", "CHROME-100");
}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+"=====start====");
		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"=====started====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+"=====end====");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"=====completed====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot t = (TakesScreenshot)BaseClass.sdriver;
		String src = t.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(src, testName +"_"+  time );
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====failed====");
		test.log(Status.FAIL, result.getThrowable()); 
		
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		 
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {    
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
