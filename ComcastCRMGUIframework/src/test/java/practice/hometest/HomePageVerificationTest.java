package practice.hometest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.google.protobuf.Method;

public class HomePageVerificationTest {
	@Test
	public void homepageTest(Method m) {
		System.out.println(m.getName()+"Test start");
		String expectedpage ="Home page";
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	//HardAssert
  
	driver.close();
	System.out.println(m.getName()+"end Test ");
	}
	
	@Test
	public void verifyLogoHomepageTest(Method m) {
		System.out.println(m.getName()+"test start");
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Assert.assertEquals(true, status);
		Assert.assertTrue(status);
		driver.close(); 
		System.out.println(m.getName()+"end Test ");
		}
	
	}


