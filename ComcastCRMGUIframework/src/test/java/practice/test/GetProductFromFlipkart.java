package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductFromFlipkart { 
	@Test(dataProviderClass  = GetProduct_Dp.class,dataProvider = "getData")
	public void getProduct(String Brandname,String productname) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://flipkart.com");
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys(Brandname,Keys.ENTER);
	String	x ="//div[text()='SONY Xperia E3 (Copper, 4 GB)']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	}

}
