package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandname,String productname) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://flipkart.com");
		//search product
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys(brandname,Keys.ENTER);
		//capture product info
		String x = "//div[text()='"+productname+"']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class='Nx9bqj _4b5DiR']";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
			int	rowcount =eLib.getRowcount("product");
		Object[][] objArr = new Object[rowcount][2];
		for(int i = 0;i<rowcount;i++) {
		objArr[i][0]	= eLib.getDataFromExcel("product", i+1, 0);
		objArr[i][1]	= eLib.getDataFromExcel("product", i+1, 1);
		}
		return objArr;}}
		
		/*objArr[0][0]="Apple iphone 14 pro max";
		objArr[0][1]="Apple iPhone 14 Pro Max (Space Black, 1 TB)";
		
		objArr[1][0]="Apple iphone 14 pro max";
		objArr[1][1]="Apple iPhone 14 Pro Max (Gold, 1 TB)";
		
		objArr[2][0]="Apple iphone 14 pro max";
		objArr[2][1]="Apple iPhone 14 Pro Max (Space Black, 512 GB)";  

		return objArr;
	}
	
	//div[text()='Apple iPhone 14 Pro Max (Space Black, 128 GB)']/ancestor::div[@class="yKfJKb row"]
}*/
